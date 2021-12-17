package org.goit.springhw8.controller;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.goit.springhw8.util.SendErrorMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.UUID;

@RestController
@RequestMapping("registration")
public class Registration {

    private final SendErrorMessage sendErrorMessage;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final PasswordEncoder passwordEncoder;

    public ModelAndView customModel(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModel(viewName, model, message);
    }

    public ModelAndView customModelOK(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModelOK(viewName, model, message);
    }

    public Registration(UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder passwordEncoder, SendErrorMessage sendErrorMessage) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.sendErrorMessage = sendErrorMessage;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registrationGet(ModelMap model) {
        return new ModelAndView("registration", String.valueOf(model), model.addAttribute("list", userDetailsServiceImpl.getGenderList()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registrationPost(User user, ModelMap model) {
        String viewName = "registration";
        if (model == null) {
            return new ModelAndView("registration");
        }
        model.addAttribute("list", userDetailsServiceImpl.getGenderList());
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(String.valueOf(UUID.randomUUID()));
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            return customModel(viewName, model, "User Name Is Null");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            return customModel(viewName, model, "User Last Name Is Null");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return customModel(viewName, model, "User Email Is Null");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return customModel(viewName, model, "User Password Is Null");
        }

        if (!userDetailsServiceImpl.findByEmail(user.getEmail()).isEmpty()) {
            return customModel(viewName, model, "The User With This Email Is Registered");
        } // check unique email

        user.setActive(true);
        user.setGender(user.getGender());
        user.setName(user.getName().toUpperCase());
        user.setLastName(user.getLastName().toUpperCase());
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsServiceImpl.saveEntity(user);
        return customModelOK("login", model, "User Is Registered.\n Now You Can To Log In");
    }
}

