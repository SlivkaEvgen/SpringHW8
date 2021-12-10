package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Gender;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;
import org.goit.springhw8.service.MyUserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

/**
 * The type Registration.
 */
@Validated
@RestController
@RequestMapping("registration")
public class Registration {

    private final MyUserDetailsService myUserDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Instantiates a new Registration.
     *
     * @param myUserDetailsService  the my user details service
     * @param bCryptPasswordEncoder the b crypt password encoder
     */
    public Registration(MyUserDetailsService myUserDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.myUserDetailsService = myUserDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * Show registration form model and view.
     *
     * @param model   the model
     * @param userDto the user dto
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(ModelMap model, @RequestBody UserDto userDto) {
        if (model == null) {
            return new ModelAndView("registration");
        }
        if (model.isEmpty()) {
            return new ModelAndView("registration", model);
        }
        return new ModelAndView("registration", model.addAttribute("user", userDto).addAttribute("list", Gender.getAll()));
    }

    /**
     * Registration model and view.
     *
     * @param user  the user
     * @param model the model
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registration(@Valid @RequestBody User user, ModelMap model) {
        List<User> userList = myUserDetailsService.getAll();
        for (User value : userList) {
            if (user.getEmail().equalsIgnoreCase(value.getEmail())) {
                model.addAttribute("error", "This Email Is Used");
                model.addAttribute("error2", "Please, Try Again");
                return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
            }
        }
        if (user.getEmail().isEmpty()) {
            model.addAttribute("error2", "Please, Try Again");
            model.addAttribute("error", "Email");
            return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
        }
        if (user.getName().isEmpty()) {
            model.addAttribute("error2", "Please, Try Again");
            model.addAttribute("error", "Name");
            return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
        }
        if (user.getLastName().isEmpty()) {
            model.addAttribute("error2", "Please, Try Again");
            model.addAttribute("error", "Last Name");
            return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
        }
        if (user.getPassword().isEmpty()) {
            model.addAttribute("error2", "Please, Try Again");
            return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user));
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setName(user.getName().toUpperCase());
        user.setLastName(user.getLastName().toUpperCase());
        user.setGender(Gender.valueOf(user.getGender().name()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        myUserDetailsService.saveEntity(user);
        return new ModelAndView("registration", model.addAttribute("list", Gender.getAll()).addAttribute("user", user).addAttribute("error2", "Registration Completed Successfully\n"));
    }
}
