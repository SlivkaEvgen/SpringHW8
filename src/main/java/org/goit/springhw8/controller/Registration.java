package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.goit.springhw8.util.SendErrorMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.UUID;

/**
 * The type Registration.
 */
@Validated
@RestController
@RequestMapping("registration")
public class Registration {

    private final SendErrorMessage sendErrorMessage;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final PasswordEncoder passwordEncoder;

    public ModelAndView customModelStandard(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModelUserStandard(viewName, model, message);
    }

    public ModelAndView customModelOK(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModelUserOK(viewName, model, message);
    }

    /**
     * Instantiates a new Registration.
     *
     * @param userDetailsServiceImpl the my user details service
     * @param passwordEncoder        the b crypt password encoder
     */
    public Registration(UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder passwordEncoder, SendErrorMessage sendErrorMessage) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.sendErrorMessage = sendErrorMessage;
    }
//OK

    /**
     * Show registration form model and view.
     *
     * @param model the model
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(ModelMap model) {
        return new ModelAndView("registration", model.addAttribute("list", userDetailsServiceImpl.getGenderList()));
    }
//OK

    /**
     * Registration model and view.
     *
     * @param user  the user
     * @param model the model
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registration(@Valid User user, ModelMap model) {
        String viewName = "registration";
        model.addAttribute("list", userDetailsServiceImpl.getGenderList());
        if (user.getId() == null) {
            user.setId(String.valueOf(UUID.randomUUID()));
        }
        if (user.getId().isEmpty()) {
            user.setId(String.valueOf(UUID.randomUUID()));
        }

        if (userDetailsServiceImpl.getById(user.getId()).isPresent()) {
            return customModelStandard(viewName, model, "User With ID " + user.getId() + "Is Used");
        }

        if (user.getName() == null) {
            return customModelStandard(viewName, model, "User Name Is Null");
        }
        if (user.getLastName() == null) {
            return customModelStandard(viewName, model, "User Last Name Is Null");
        }
        if (user.getEmail() == null) {
            return customModelStandard(viewName, model, "User Email Is Null");
        }
        if (user.getPassword() == null) {
            return customModelStandard(viewName, model, "User Password Is Null");
        }

        if (user.getName().isEmpty()) {
            return customModelStandard(viewName, model, "User Name Is Empty");
        }
        if (user.getLastName().isEmpty()) {
            return customModelStandard(viewName, model, "User Last Name Is Empty");
        }
        if (user.getEmail().isEmpty()) {
            return customModelStandard(viewName, model, "User Email Is Empty");
        }
        if (user.getPassword().isEmpty()) {
            return customModelStandard(viewName, model, "User Password Is Empty");
        }

        for (User value : userDetailsServiceImpl.getAll()) {
            if (user.getEmail().equals(value.getEmail())) {
                return customModelStandard(viewName, model, "The User With This Email Is Registered");
            }
        }

        user.setGender(user.getGender());
        user.setName(user.getName().toUpperCase());
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsServiceImpl.saveEntity(user);
        userDetailsServiceImpl.saveEntity(user);
        return customModelOK("login", model, "User Is Registered.\n Now You Can To Log In");
    }
}

