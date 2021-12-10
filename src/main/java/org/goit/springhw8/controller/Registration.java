package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Gender;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;
import org.goit.springhw8.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Validated
@RestController
@RequestMapping("registration")
public class Registration {

    private final UserService userService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Registration(UserService userService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(ModelMap model,@ModelAttribute UserDto userDto) {
        if (model==null){
            return new ModelAndView("registration");
        }
        if (model.isEmpty()) {
            return new ModelAndView("registration", model);
        }
        return new ModelAndView("registration", model.addAttribute("user", userDto).addAttribute("list", Gender.getAll()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registration(@Valid @ModelAttribute User user, ModelMap model) {
        List<User> userList = userService.getAll();
        for (User value : userList) {
            if (user.getEmail().equalsIgnoreCase(value.getEmail())) {
                model.addAttribute("error", "This Email Is Used");
                model.addAttribute("error2", "Please, Try Again");
                return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
            }
        }
        if (user.getEmail().isEmpty()){
            model.addAttribute("error2", "Please, Try Again");
            model.addAttribute("error", "Email");
            return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
        }
        if (user.getName().isEmpty()){
            model.addAttribute("error2", "Please, Try Again");
            model.addAttribute("error", "Name");
            return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
        }
        if (user.getLastName().isEmpty()){
            model.addAttribute("error2", "Please, Try Again");
            model.addAttribute("error", "Last Name");
            return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
        }
        if (user.getPassword().isEmpty()){
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setName(user.getName().toUpperCase());
        user.setLastName(user.getLastName().toUpperCase());
        user.setGender(Gender.valueOf(user.getGender().name()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userService.saveEntity(user);
        return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user).addAttribute("error2", "Registration Completed Successfully\n"));
    }
}
