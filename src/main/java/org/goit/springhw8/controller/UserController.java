package org.goit.springhw8.controller;

import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserService;
import org.goit.springhw8.util.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ModelAndView getAllUsers(@NotNull ModelMap model) {
        return new ModelAndView("user/list", model.addAttribute("list", userService.getList()));
    }

    @GetMapping("id")
    public ModelAndView findById(String id, ModelMap model) {
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
        return new ModelAndView("user/userById", model.addAttribute("list", userService.findListById(id)));
    }

    @GetMapping("name")
    public ModelAndView findByUserName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("user/userByName", model);
        }
        model.addAttribute("list", userService.getByName(name.toUpperCase()));
        return new ModelAndView("user/userByName", model);
    }

    @GetMapping("delete")
    public ModelAndView delete(String id, ModelMap model) {
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
        if (userService.getById(id).get().getName().equalsIgnoreCase("admin")) {
            model.addAttribute("error", "Sorry, You Cannot Delete The Administrator");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/deleteUser", model);
        }
        userService.deleteById(id);
        return new ModelAndView("redirect:/user", model);
    }

    @GetMapping("new")
    public ModelAndView addNew(User user, @NotNull ModelMap model) {
        return new ModelAndView("user/newUser", model.addAttribute("user", user));
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost(@NotNull User user, ModelMap model) {
        if (user.getId() == null) {
            return new ModelAndView("user/newUser", model);
        }
        userService.saveEntity(user);
        return new ModelAndView("user/user", model.addAttribute("user", user));
    }

    @GetMapping("update/**")
    public ModelAndView update(User user, @NotNull ModelMap model) {
        return new ModelAndView("user/updateUser", model.addAttribute("user", user));
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(@NotNull User user, ModelMap model) {
        if (!Validator.validId(user.getId())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getName().equalsIgnoreCase("admin")) {
            model.addAttribute("error", "Sorry, You Cannot Update The Administrator");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/updateUser", model);
        }
        userService.saveEntity(user);
        return new ModelAndView("user/user", model);
    }
}