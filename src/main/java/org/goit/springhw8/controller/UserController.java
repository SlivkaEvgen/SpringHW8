package org.goit.springhw8.controller;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserService;
import org.goit.springhw8.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    private String message = "";

    @GetMapping("user")
    public ModelAndView entity( ModelMap model) {
        model.addAttribute("error", this.message);
        this.message = "";
        return new ModelAndView("user/user", model);
    }

    // DONE
    @GetMapping("list")
    public ModelAndView getAllUsers(ModelMap model) {
        return new ModelAndView("user/list", model.addAttribute("list", userService.getAllUsers()));
    }

    @GetMapping("id")
    public ModelAndView findById(ModelMap model, String id) {
        if (id == null) {
            return new ModelAndView("user/userById", model);
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("user/userById", model);
        }
        Optional<User> optionalUser = userService.findUserById(Long.valueOf(id));
        if (!optionalUser.isPresent()) {
            return new ModelAndView("user/userById", model);
        }
        model.addAttribute("user", optionalUser.get());
        return new ModelAndView("user/userById", model);
    }

    @GetMapping("name")
    public ModelAndView findByUserName(ModelMap model, String name) {
        if (name == null) {
            return new ModelAndView("user/userByName", model);
        }
        model.addAttribute("list", userService.findUserByName(name.toUpperCase()));
        return new ModelAndView("user/userByName", model);
    }

    @GetMapping("delete")
    public ModelAndView delete(ModelMap model, String id) {
        if (id == null) {
            return new ModelAndView("user/deleteUser", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/deleteUser", model);
        }
        if (!userService.findUserById(Long.parseLong(id)).isPresent()) {
            model.addAttribute("error", "User With ID = " + id + " Is Empty");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/deleteUser", model);
        }
        userService.deleteUser(Long.parseLong(id));
        this.message = "User With ID = " + id + "\n Removed ";
        model.addAttribute("error", message);
        model.addAttribute("error2", message);
        return new ModelAndView("redirect:/user", model);
    }

    @GetMapping("new")
    public ModelAndView addNew(ModelMap model, String id, String name, String lastName, String gender, String email, String password) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role(1L, "ROLE_USER"));
        if (id == null) {
            return new ModelAndView("user/newUser", model);
        }
//        userService.saveUser(new User(Long.parseLong(id), name.toUpperCase(), lastName, gender, email, password, roleSet, true));
        return new ModelAndView("user/user", model);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(ModelMap model, User user) {
        if (user.getId() == null) {
            return new ModelAndView("user/newUser", model);
        }
        userService.saveUser(user);
        model.addAttribute("user", user);
        return new ModelAndView("user/user", model);
    }

    @GetMapping("update/**")
    public ModelAndView update(ModelMap model, User user) {
        model.addAttribute("error", message);
        return new ModelAndView("user/updateUser", model);
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(User user, ModelMap model) {
        if (!Validator.validId(user.getId().toString())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("user/updateUser", model);
        }
        userService.saveUser(user);
        this.message = "User With ID = " + user.getId() + " Updated";
        model.addAttribute("error", this.message);
        return new ModelAndView("user/user", model);
    }
}