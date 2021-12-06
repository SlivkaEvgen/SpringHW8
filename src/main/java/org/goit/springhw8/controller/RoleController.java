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

import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@Log4j2
//@Validated
@Controller
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("role")
    public ModelAndView entity(ModelMap model) {
        System.out.println("RoleController entity");
        return new ModelAndView("role/role", model);
    }

    @GetMapping("list")
    public ModelAndView getAllRoles(@NotNull ModelMap model) {
        System.out.println("RoleController getAllRoles");
        return new ModelAndView("role/list", model.addAttribute("list", roleService.getList()));
    }

    @GetMapping("name")
    public ModelAndView findByRoleName(String name, ModelMap model) {
        System.out.println("RoleController findByRoleName");
        System.out.println("findByRoleName " + name);
        if (name == null) {
            return new ModelAndView("role/roleByName", model);
        }
        List<Role> byRoleName = roleService.getByName(name);
        if (byRoleName.size() == 0) {
            model.addAttribute("error", "Not Found Role With Name = " + name);
            model.addAttribute("error2", " Please, Try Again ");
        }
        System.out.println("roleService.findByRoleName(name)");
        return new ModelAndView("role/roleByName", model.addAttribute("list", roleService.getByName(name)));
    }

    @GetMapping("id")
    public ModelAndView findById(String id, ModelMap model) {
        System.out.println("RoleController findById");
        if (id == null) {
            return new ModelAndView("role/roleById", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", " Please, Try Again ");
            return new ModelAndView("role/roleById", model);
        }
        Optional<Role> optionalRole = roleService.getById(id);
        if (!optionalRole.isPresent()) {
            model.addAttribute("error", " No Found Role By ID = " + id);
            model.addAttribute("error2", " Please, Try Again ");
            return new ModelAndView("role/roleById", model);
        }
        return new ModelAndView("role/roleById", model.addAttribute("list", roleService.findListById(id)));
    }

    @GetMapping("delete")
    public ModelAndView delete(String id, ModelMap model) {
        System.out.println("RoleController delete");
        if (id == null) {
            return new ModelAndView("role/deleteRole", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("role/deleteRole", model);
        }
        if (!roleService.getById(id).isPresent()) {
            model.addAttribute("error", "Role With ID = " + id + " Is Empty");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("role/deleteRole", model);
        }
        if (roleService.getById(id).get().getName().equalsIgnoreCase("admin")) {
            model.addAttribute("error", "Sorry, The Admin Role Cannot Be Deleted");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("role/deleteRole", model);
        }
        if (Objects.equals(model.getAttribute("role"), "USER")){
            model.addAttribute("error", "Sorry, Only Admin Can Delete");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("role/deleteRole", model);
        }
        roleService.deleteById(id);
        return new ModelAndView("role/role", model.addAttribute("error2", "Role With ID = " + id + "\n Deleted "));
    }

    @GetMapping("new")
    public ModelAndView addNew(Role role, ModelMap model) {
        return new ModelAndView("role/newRole", model.addAttribute("role", role));
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(@NotNull Role role, ModelMap model) {
        System.out.println("RoleController addNewPost " + role.getId());
        System.out.println("RoleController addNewPost " + role.getName());
        if (role.getId() == null) {
            return new ModelAndView("role/newRole", model);
        }
        if (role.getName() == null) {
            return new ModelAndView("role/newRole", model);
        }
        if (!Validator.validId(role.getId())) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Please,Try Again");
            return new ModelAndView("role/newRole", model);
        }
        if (!Validator.validName(role.getName().toUpperCase())) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Please,Try Again");
            return new ModelAndView("role/newRole", model);
        }
        if (roleService.getById(role.getId()).isPresent()) {
            model.addAttribute("error", "Role With ID " + role.getName() + " Is Used");
            model.addAttribute("error2", "Please,Try Again");
            return new ModelAndView("role/newRole", model);
        }
        if (!roleService.getByName(role.getName().toUpperCase()).isEmpty()) {
            model.addAttribute("error", "Role With Name " + role.getName() + " Is Used");
            model.addAttribute("error2", "Please,Try Again");
            return new ModelAndView("role/newRole", model);
        }
        roleService.saveEntity(new Role(role.getId(), role.getName().toUpperCase()));
        return new ModelAndView("role/role", model.addAttribute("error2", "Role " + " Added"));
    }

    @GetMapping("update/**")
    public ModelAndView update(Role role, ModelMap model) {
        return new ModelAndView("role/updateRole", model.addAttribute("role", role));
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(@NotNull Role role,  ModelMap model) {
        System.out.println("RoleController updatePost");
        if (!Validator.validId(role.getId())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("role/updateRole", model);
        }
        if (!roleService.getById(role.getId()).isPresent()) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Role With ID " + role.getId() + " Not Found");
            return new ModelAndView("role/updateRole", model);
        }
        if (!roleService.getByName(role.getName().toUpperCase()).isEmpty()) {
            model.addAttribute("error", "Role With Name " + role.getName() + " Is Used");
            model.addAttribute("error2", "Please,Try Again");
            return new ModelAndView("role/updateRole", model);
        }
        if (roleService.getById(role.getId()).get().getName().equalsIgnoreCase("admin")) {
            model.addAttribute("error", "Sorry, The Admin Role Cannot Be Changed");
            model.addAttribute("error2", "Please,Try Again");
            return new ModelAndView("role/updateRole", model);
        }
        roleService.saveEntity(new Role(role.getId(), role.getName().toUpperCase()));
        return new ModelAndView("role/role", model.addAttribute("error2", role + "\n Updated "));
    }
}
