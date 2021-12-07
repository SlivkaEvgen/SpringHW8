package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;
import org.goit.springhw8.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("registration")
    public String registration(@NotNull Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(@ModelAttribute("userForm") @Valid UserDto userForm, @NotNull BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("RegistrationController addUser hasErrors");
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            System.out.println("RegistrationController addUser : userForm.getPassword().equals(userForm.getPasswordConfirm())");
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!userService.saveUser(userForm)) {
            System.out.println("RegistrationController addUser : !userService.saveUser(userForm)");
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        return "redirect:/";
    }
}
