package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Gender;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.goit.springhw8.util.SendError;
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

    private final SendError sendError;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final PasswordEncoder passwordEncoder;

    public ModelAndView customModelStandard(String viewName, ModelMap model, Object message) {
        return sendError.customModelUserStandard(viewName, model, message);
    }

    public ModelAndView customModelFull(String viewName, ModelMap model, User user, Object message) {
        return sendError.customModelUser(viewName, model, user, message);
    }

    /**
     * Instantiates a new Registration.
     *
     * @param userDetailsServiceImpl the my user details service
     * @param passwordEncoder      the b crypt password encoder
     */
    public Registration(UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder passwordEncoder, SendError sendError) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.sendError = sendError;
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
        return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()));//.addAttribute("list3", myUserDetailsService.getRoles()).addAttribute("list2", myUserDetailsService.getGenderList()));
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
        model.addAttribute("list", Gender.getAll());
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
        if (user.getName().isEmpty()) {
            return customModelStandard(viewName, model, "User Name Is Empty");
        }
        if (user.getLastName() == null) {
            return customModelStandard(viewName, model, "User Last Name Is Null");
        }
        if (user.getLastName().isEmpty()) {
            return customModelStandard(viewName, model, "User Last Name Is Empty");
        }
        if (user.getEmail().isEmpty()) {
            return customModelStandard(viewName, model, "User Email Is Empty");
        }
        if (user.getEmail() == null) {
            return customModelStandard(viewName, model, "User Email Is Null");
        }
        if (user.getPassword().isEmpty()) {
            return customModelStandard(viewName, model, "User Password Is Empty");
        }
        if (user.getPassword() == null) {
            return customModelStandard(viewName, model, "User Password Is Null");
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
        return customModelFull("login", model.addAttribute("ERROR", "SUCCESSFULLY").addAttribute("ERROR2", "SUCCESSFULLY"), user, "User Is Registered.\n Now You Can To Log In");
    }
}

