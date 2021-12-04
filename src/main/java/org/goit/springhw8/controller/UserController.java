package org.goit.springhw8.controller;

import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserService;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("user/user", model);
    }

    @GetMapping("list")
    public ModelAndView getAllUsers(ModelMap model) {
        return new ModelAndView("user/list", model.addAttribute("list", userService.getList()));
    }

    @GetMapping("id")
    public ModelAndView findById(ModelMap model,@ModelAttribute String id) {
        if (id == null) {
            return new ModelAndView("user/userById", model);
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("user/userById", model);
        }
        Optional<User> optionalUser = userService.getById(id);
        if (!optionalUser.isPresent()) {
            return new ModelAndView("user/userById", model);
        }
        model.addAttribute("user", optionalUser.get());
        return new ModelAndView("user/userById", model);
    }

    @GetMapping("name")
    public ModelAndView findByUserName(ModelMap model,@ModelAttribute String name) {
        if (name == null) {
            return new ModelAndView("user/userByName", model);
        }
        model.addAttribute("list", userService.getByName(name.toUpperCase()));
        return new ModelAndView("user/userByName", model);
    }

    @GetMapping("delete")
    public ModelAndView delete(ModelMap model,@ModelAttribute String id) {
        if (id == null) {
            return new ModelAndView("user/deleteUser", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/deleteUser", model);
        }
        if (!userService.getById(id).isPresent()) {
            model.addAttribute("error", "User With ID = " + id + " Is Empty");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/deleteUser", model);
        }
        userService.deleteById(id);
        return new ModelAndView("redirect:/user", model);
    }

    @GetMapping("new")
    public ModelAndView addNew(ModelMap model) {
        return new ModelAndView("user/newUser", model);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(ModelMap model, User user) {
        if (user.getId() == null) {
            return new ModelAndView("user/newUser", model);
        }
        userService.saveEntity(user);
        return new ModelAndView("user/user", model.addAttribute("user", user));
    }

    @GetMapping("update/**")
    public ModelAndView update(ModelMap model) {
        return new ModelAndView("user/updateUser", model);
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(User user, ModelMap model) {
        if (!Validator.validId(user.getId())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("user/updateUser", model);
        }
        userService.saveEntity(user);
        return new ModelAndView("user/user", model);
    }
}