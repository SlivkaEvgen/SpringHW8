package org.goit.springhw8.service;

import jakarta.validation.Valid;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.goit.springhw8.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Logger
@Controller
@RequestMapping("registration")
public class Registration {

    private final UserService userService;

    public Registration(UserService userService){
        this.userService=userService;
    }

    @GetMapping("registration/**")
    public String registration(String name,Model model) {
        System.out.println("model "+model);
        System.out.println("user "+name);
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "registration/**")
    public String addUser(@ModelAttribute("userForm")
                              @Valid User userForm,
                          BindingResult bindingResult, Model model) {
        System.out.println("userForm "+ userForm);
        System.out.println("BindingResult "+ bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!userService.saveEntity(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        return "redirect:/home";
    }

    @PostMapping(value = "registration/**", name = "user")
    public String addUser2(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model){
        System.out.println(user);
        System.out.println(bindingResult);
        System.out.println(model);
        userService.saveEntity(user);
        return "redirect:/home";
    }

}
