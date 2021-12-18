package org.goit.springhw8.controller;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.util.SendErrorMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Service
public class SetIntoUser {

    private final PasswordEncoder passwordEncoder;
    private final SendErrorMessage sendErrorMessage;

    public SetIntoUser(PasswordEncoder passwordEncoder,SendErrorMessage sendErrorMessage){
        this.passwordEncoder=passwordEncoder;
        this.sendErrorMessage=sendErrorMessage;
    }

    public ModelAndView customModel(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModel(viewName, model, message);
    }

    public User setUser(User user){
        if (user!=null) {
            user.setActive(true);
            user.setGender(user.getGender());
            user.setName(user.getName().toUpperCase());
            user.setLastName(user.getLastName().toUpperCase());
            user.setRoles(Collections.singleton(Role.ROLE_USER));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return user;
    }

    public ModelAndView NotNullNotEmpty(String viewName, User user, ModelMap model) {
        if (user != null) {
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
        }
        return customModel(viewName, model, "");
    }
}
