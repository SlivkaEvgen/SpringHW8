package org.goit.springhw8.controller;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.service.RoleService;
import org.goit.springhw8.util.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("role")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("role/role", model);
    }

    @GetMapping("list")
    public ModelAndView getAllRoles(@NotNull ModelMap model) {
        return new ModelAndView("role/list", model.addAttribute("list", roleService.getList()));
    }

    @GetMapping("name")
    public ModelAndView findByRoleName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("role/roleByName", model);
        }
        if (name.isEmpty()) {
            return new ModelAndView("role/roleByName", model.addAttribute("name", name).addAttribute("error", "Role Name Is Empty").addAttribute("error2", " Please, Try Again "));
        }
        if (!Validator.validName(name)) {
            return new ModelAndView("role/roleByName", model.addAttribute("name", name).addAttribute("error", "Wrong Role Name = " + name).addAttribute("error2", " Please, Try Again "));
        }
        if (roleService.getByName(name).isEmpty()) {
            return new ModelAndView("role/roleByName", model.addAttribute("name", name).addAttribute("error", "Not Found Role With Name = " + name).addAttribute("error2", " Please, Try Again "));
        }
        return new ModelAndView("role/roleByName", model.addAttribute("list", roleService.getByName(name)).addAttribute("error", "SUCCESSFULLY"));
    }

    @GetMapping("id")
    public ModelAndView findById(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("role/roleById", model);
        }
        if (id.isEmpty()) {
            return new ModelAndView("role/roleById", model.addAttribute("id", id).addAttribute("error", "Role ID Is Empty").addAttribute("error2", " Please, Try Again "));
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("role/roleById", model.addAttribute("id", id).addAttribute("error", "Wrong Role ID").addAttribute("error2", " Please, Try Again "));
        }
        if (!roleService.getById(id).isPresent()) {
            return new ModelAndView("role/roleById", model.addAttribute("id", id).addAttribute("error", " No Found Role By ID = " + id).addAttribute("error2", " Please, Try Again "));
        }
        return new ModelAndView("role/roleById", model.addAttribute("list", roleService.findListById(id)).addAttribute("error", "SUCCESSFULLY"));
    }

    @GetMapping("delete")
    public ModelAndView delete(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("role/deleteRole", model);
        }
        if (id.isEmpty()) {
            return new ModelAndView("role/deleteRole", model.addAttribute("id", id).addAttribute("error", "Role ID Is Empty").addAttribute("error2", "Try again"));
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("role/deleteRole", model.addAttribute("id", id).addAttribute("error", "Wrong Role ID").addAttribute("error2", "Try again"));
        }
        if (!roleService.getById(id).isPresent()) {
            return new ModelAndView("role/deleteRole", model.addAttribute("id", id).addAttribute("error", "Role With ID = " + id + " Is Empty").addAttribute("error2", "Try again"));
        }
        // If Admin
        if (roleService.getById(id).get().getName().equalsIgnoreCase("ROLE_ADMIN")) {
            return new ModelAndView("role/deleteRole", model.addAttribute("id", id).addAttribute("error", "Sorry, The Admin Role Cannot Be Deleted").addAttribute("error2", "Try again"));
        }
        if (!Objects.equals(model.getAttribute("role"), "ROLE_ADMIN")) {
            return new ModelAndView("role/deleteRole", model.addAttribute("error", "Sorry, Only Admin Can Delete").addAttribute("error2", "Try again"));
        }
        roleService.deleteById(id);
        return new ModelAndView("role/role", model.addAttribute("error", "Role With ID = " + id + "\n Deleted ").addAttribute("error2", "SUCCESSFULLY"));
    }

    @GetMapping("new")
    public ModelAndView addNew(Role role, @NotNull ModelMap model) {
        return new ModelAndView("role/newRole", model.addAttribute("role", role));
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(@NotNull Role role, ModelMap model) {
        if (role.getId() == null) {
            return new ModelAndView("role/newRole", model.addAttribute("role", role).addAttribute("error", "Role ID Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (role.getName() == null) {
            return new ModelAndView("role/newRole", model.addAttribute("role", role).addAttribute("error", "Role Name Is Null").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validId(role.getId())) {
            return new ModelAndView("role/newRole", model.addAttribute("role", role).addAttribute("error", "Wrong Role ID").addAttribute("error2", "Please,Try Again"));
        }
        if (!Validator.validName(role.getName().toUpperCase())) {
            return new ModelAndView("role/newRole", model.addAttribute("role", role).addAttribute("error", "Wrong Role Name").addAttribute("error2", "Please,Try Again"));
        }
        if (roleService.getById(role.getId()).isPresent()) {
            return new ModelAndView("role/newRole", model.addAttribute("role", role).addAttribute("error", "Role With ID " + role.getId() + " Is Used").addAttribute("error2", "Please,Try Again"));
        }
        if (!roleService.getByName(role.getName().toUpperCase()).isEmpty()) {
            return new ModelAndView("role/newRole", model.addAttribute("role", role).addAttribute("error", "Role With Name " + role.getName() + " Is Used").addAttribute("error2", "Please,Try Again"));
        }
        role.setName(role.getName().toUpperCase());
        roleService.saveEntity(role);
        return new ModelAndView("role/role", model.addAttribute("error2", "New Role Added").addAttribute("error", "SUCCESSFULLY"));
    }

    @GetMapping("update/**")
    public ModelAndView update(Role role, @NotNull ModelMap model) {
        return new ModelAndView("role/updateRole", model.addAttribute("role", role));
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(@NotNull Role role, ModelMap model) {
        if (role.getId() == null) {
            return new ModelAndView("role/updateRole", model.addAttribute("role", role).addAttribute("error", "Role ID Is Null").addAttribute("error2", "Try Again"));
        }
        if (role.getName() == null) {
            return new ModelAndView("role/updateRole", model.addAttribute("role", role).addAttribute("error", "Role Name Is Null").addAttribute("error2", "Try Again"));
        }
        if (role.getId().isEmpty()) {
            return new ModelAndView("role/updateRole", model.addAttribute("role", role).addAttribute("error", "Role ID Is Empty").addAttribute("error2", "Try Again"));
        }
        if (role.getName().isEmpty()) {
            return new ModelAndView("role/updateRole", model.addAttribute("role", role).addAttribute("error", "Role Name Is Empty").addAttribute("error2", "Try Again"));
        }
        if (role.getName().equalsIgnoreCase("admin")) {
            return new ModelAndView("role/updateRole", model.addAttribute("error", "It Is Impossible To Remove The Admin ").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validId(role.getId())) {
            return new ModelAndView("role/updateRole", model.addAttribute("role", role).addAttribute("error", "Wrong Role ID").addAttribute("error2", "Please,Try Again"));
        }
        if (!Validator.validName(role.getName())) {
            return new ModelAndView("role/updateRole", model.addAttribute("role", role).addAttribute("error", "Wrong Role Name").addAttribute("error2", "Please,Try Again"));
        }
        if (!roleService.getById(role.getId()).isPresent()) {
            return new ModelAndView("role/updateRole", model.addAttribute("role", role).addAttribute("error", "Role With ID " + role.getId() + " Not Found").addAttribute("error2", "Try Again"));
        }
        if (!roleService.getByName(role.getName().toUpperCase()).isEmpty()) {
            return new ModelAndView("role/updateRole", model.addAttribute("role", role).addAttribute("error", "Role With Name " + role.getName() + " Is Used").addAttribute("error2", "Please,Try Again"));
        }
        if (roleService.getById(role.getId()).get().getName().equalsIgnoreCase("admin")) {
            return new ModelAndView("role/updateRole", model.addAttribute("role", role).addAttribute("error", "Sorry, The Admin Role Cannot Be Changed").addAttribute("error2", "Please,Try Again"));
        }
        role.setName(role.getName().toUpperCase());
        roleService.saveEntity(role);
        return new ModelAndView("role/role", model.addAttribute("error2", role + "\n Updated ").addAttribute("error", "SUCCESSFULLY"));
    }
}
