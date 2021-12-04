package org.goit.springhw8.controller;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.service.RoleService;
import org.goit.springhw8.service.ServiceI;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService=roleService;
    }

    @GetMapping("role")
    public ModelAndView entity(ModelMap model) {
        System.out.println("RoleController entity");
        return new ModelAndView("role/role", model);
    }

    @GetMapping("list")
    public ModelAndView getAllRoles(ModelMap model) {
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
        model.addAttribute("list", roleService.getByName(name));
        return new ModelAndView("role/roleByName", model);
    }

    @GetMapping("id")
    public ModelAndView findById(ModelMap model, String id) {
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
        model.addAttribute("role", optionalRole.get());
        return new ModelAndView("role/roleById", model);
    }

    @GetMapping("delete")
    public ModelAndView delete(ModelMap model, String id) {
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
        roleService.deleteById(id);
        model.addAttribute("error2", "Role With ID = " + id + "\n Removed ");
        return new ModelAndView("role/role", model);
    }

    @GetMapping("update/**")
    public ModelAndView update(ModelMap model, Role role) {
        model.addAttribute("role", role);
        return new ModelAndView("role/updateRole", model);
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(Role role, ModelMap model) {
        System.out.println("RoleController updatePost");
        if (!Validator.validId(role.getId().toString())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("role/role", model);
        }
        roleService.saveEntity(role);
        model.addAttribute("error2", role + "\n Updated ");
        return new ModelAndView("role/role", model);
    }

    @GetMapping("new")
    public ModelAndView addNew(ModelMap model) {
        return new ModelAndView("role/newRole", model);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(ModelMap model, String id, String name) {
        System.out.println("RoleController addNewPost " + id);
        System.out.println("RoleController addNewPost " + name);
        if (id == null) {
            return new ModelAndView("role/newRole", model);
        }
        if (name == null) {
            return new ModelAndView("role/newRole", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Please,Try Again");
            return new ModelAndView("role/newRole", model);
        }
        if (!Validator.validName(name)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Please,Try Again");
            return new ModelAndView("role/newRole", model);
        }
        if (roleService.getById(id).isPresent()) {
            model.addAttribute("error", "Role With ID " + id + " Is Used");
            model.addAttribute("error2", "Please,Try Again");
            return new ModelAndView("role/newRole", model);
        }
        roleService.saveEntity(new Role(id, name));
        model.addAttribute("error2", "Role " + " Added");
        return new ModelAndView("role/role", model);
    }
}
