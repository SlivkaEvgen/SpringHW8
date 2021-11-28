package org.goit.springhw8.controller;

import lombok.NonNull;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.service.RoleService;
import org.goit.springhw8.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    private String message = "";

    //  DONE
    @GetMapping("role")
    public ModelAndView entity( ModelMap model) {
        model.addAttribute("error", this.message);
        this.message = "";
        return new ModelAndView("role/role", model);
    }

    //  DONE
    @GetMapping("list")
    public ModelAndView getAllRoles( ModelMap model) {
        return new ModelAndView("role/list", model.addAttribute("list", roleService.getAllRoles()));
    }

    @GetMapping("name")
    public ModelAndView findByRoleName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("role/roleByName", model);
        }
        model.addAttribute("list", roleService.findByRoleName(name));
        return new ModelAndView("role/roleByName", model);
    }

    @GetMapping("id")
    public ModelAndView findById(ModelMap model, String id) {
        if (id == null) {
            return new ModelAndView("role/roleById", model);
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("role/roleById", model);
        }
        Optional<Role> optionalRole = roleService.findById(id);
        if (!optionalRole.isPresent()) {
            return new ModelAndView("role/roleById", model);
        }
        model.addAttribute("role", optionalRole.get());
        return new ModelAndView("role/roleById", model);
    }

    @GetMapping("delete")
    public ModelAndView delete(ModelMap model, String id) {
        if (id == null) {
            return new ModelAndView("role/deleteRole", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("role/deleteRole", model);
        }
        if (!roleService.findById(id).isPresent()) {
            model.addAttribute("error", "Role With ID = " + id + " Is Empty");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("role/deleteRole", model);
        }
        roleService.deleteRole(id);
        this.message = "Role With ID = " + id + "\n Removed ";
        model.addAttribute("error2", message);
        return new ModelAndView("redirect:/role", model);
    }

    @GetMapping("update/**")
    public ModelAndView update(@NonNull ModelMap model, Role role) {
        model.addAttribute("error", message);
        return new ModelAndView("role/updateRole", model);
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(@NonNull Role role, ModelMap model) {
        if (!Validator.validId(role.getId().toString())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("role/updateUser", model);
        }
        roleService.saveRole(role);
        this.message = "User With ID = " + role.getId() + " Updated";
        model.addAttribute("error", this.message);
        return new ModelAndView("role/updateRole", model);
    }

    @GetMapping("new")
    public ModelAndView addNew(ModelMap model, String id, String name) {
        if (id == null) {
            return new ModelAndView("role/newRole", model);
        }
        roleService.saveRole(new Role(Long.parseLong(id), name));
        return new ModelAndView("role/role", model);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(ModelMap model, Role role) {
        if (role == null) {
            return new ModelAndView("role/newRole", model);
        }
        model.addAttribute("role", role);
        roleService.saveRole(role);
        return new ModelAndView("role/role", model);
    }
}
