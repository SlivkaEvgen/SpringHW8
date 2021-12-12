package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.goit.springhw8.util.SendErrorMessage;
import org.goit.springhw8.util.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.UUID;

/**
 * The type User controller.
 */
@Validated
@Controller
@RequestMapping(value = "user")
public class UserController {

    private final SendErrorMessage sendErrorMessage;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final PasswordEncoder passwordEncoder;

    private String viewName = "";

    /**
     * Instantiates a new User controller.
     *
     * @param userDetailsServiceImpl the my user details service
     */
    public UserController(SendErrorMessage sendErrorMessage, UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder passwordEncoder) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.sendErrorMessage = sendErrorMessage;
    }

    public ModelAndView getStandardCustomModel(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModelUserStandard(viewName, model, message);
    }

    public ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModelUserOK(viewName, model, errorMessage);
    }
//OK

    /**
     * Entity user model and view.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping("user")
    public ModelAndView entityUser(ModelMap model) {
        return new ModelAndView("user/user", model);
    }
//OK

    /**
     * Gets all users.
     *
     * @param model the model
     * @return the all users
     */
    @GetMapping("list")
    public ModelAndView getAllUsers(@NotNull ModelMap model) {
        return new ModelAndView("user/list", model.addAttribute("list", userDetailsServiceImpl.getAll()));
    }
//OK

    /**
     * Gets user by id.
     *
     * @param id    the id
     * @param model the model
     * @return the user by id
     */
    @GetMapping("id")
    public ModelAndView getUserById(String id, ModelMap model) {
        viewName = "user/userById";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!userDetailsServiceImpl.getById(id).isPresent()) {
            return getStandardCustomModel(viewName, model.addAttribute("list", userDetailsServiceImpl.findListByEntityId(id)), "User With The ID = " + id + ",\n Is Not Found");
        }
        return customModelOk(viewName, model.addAttribute("list", userDetailsServiceImpl.findListByEntityId(id)), "");
    }
//OK

    /**
     * Gets user by name.
     *
     * @param name  the name
     * @param model the model
     * @return the user by name
     */
    @GetMapping("name")
    public ModelAndView getUserByName(String name, ModelMap model) {
        viewName = "user/userByName";
        if (name == null) {
            return new ModelAndView(viewName, model);
        }
        if (userDetailsServiceImpl.findByName(name).isEmpty()) {
            return getStandardCustomModel(viewName, model.addAttribute("list", userDetailsServiceImpl.findListByEntityId(name)), "User With The Name = " + name + ",\n Is Not Found");
        }
        return customModelOk(viewName, model.addAttribute("list", userDetailsServiceImpl.findByName(name)), "");
    }
//OK

    /**
     * Delete user by id model and view.
     *
     * @param id    the id
     * @param model the model
     * @return the model and view
     */
    @GetMapping("delete")
    public ModelAndView deleteUserById(String id, ModelMap model) {
        viewName = "user/deleteUser";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!userDetailsServiceImpl.getById(id).isPresent()) {
            return getStandardCustomModel(viewName, model, "User With The ID = " + id + ",\n Is Not Found");
        }
        userDetailsServiceImpl.deleteById(id);
        return customModelOk("user/user", model, "User Deleted");
    }
//OK

    /**
     * Add new user get model and view.
     *
     * @param user  the user
     * @param model the model
     * @return the model and view
     */
    @GetMapping("new/**")
    public ModelAndView addNewUserGet(@Valid User user, ModelMap model) {
        return new ModelAndView("user/newUser", model.addAttribute("user", user).addAttribute("list2", userDetailsServiceImpl.getGenderList()).addAttribute("list3", userDetailsServiceImpl.getRoleList()));
    }
//OK

    /**
     * Add new user post model and view.
     *
     * @param user  the user
     * @param model the model
     * @return the model and view
     */
    @RequestMapping(value = "new/**", method = RequestMethod.POST)
    public ModelAndView addNewUserPost(@Valid User user, ModelMap model) {
        viewName = "user/newUser";
        model.addAttribute("list2", userDetailsServiceImpl.getGenderList());
        model.addAttribute("list3", userDetailsServiceImpl.getRoleList());

        if (user.getId() == null) {
            user.setId(String.valueOf(UUID.randomUUID()));
        }
        if (user.getId().isEmpty()) {
            user.setId(String.valueOf(UUID.randomUUID()));
        }

        if (userDetailsServiceImpl.getById(user.getId()).isPresent()) {
            return getStandardCustomModel(viewName, model, "User With ID " + user.getId() + "Is Used");
        }

        if (user.getName() == null) {
            return getStandardCustomModel(viewName, model, "User Name Is Null");
        }
        if (user.getLastName() == null) {
            return getStandardCustomModel(viewName, model, "User Last Name Is Null");
        }
        if (user.getEmail() == null) {
            return getStandardCustomModel(viewName, model, "User Email Is Null");
        }
        if (user.getPassword() == null) {
            return getStandardCustomModel(viewName, model, "User Password Is Null");
        }

        if (user.getName().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Name Is Empty");
        }
        if (user.getLastName().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Last Name Is Empty");
        }
        if (user.getEmail().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Email Is Empty");
        }
        if (user.getPassword().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Password Is Empty");
        }

        for (User value : userDetailsServiceImpl.getAll()) {
            if (user.getEmail().equals(value.getEmail())) {
                return getStandardCustomModel(viewName, model, "The User With This Email Is Registered");
            }
        }

        user.setActive(true);
        user.setGender(user.getGender());
        user.setName(user.getName().toUpperCase());
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsServiceImpl.saveEntity(user);
        return customModelOk(viewName, model, "User Is Registered.\n Now You Can To Log In");
    }
//OK

    /**
     * Update user get model and view.
     *
     * @param user  the user
     * @param model the model
     * @return the model and view
     */
    @GetMapping("update/**")
    public ModelAndView updateUserGet(@Valid User user, ModelMap model) {
        return new ModelAndView("user/updateUser", model.addAttribute("user", user).addAttribute("list3", userDetailsServiceImpl.getRoleList()).addAttribute("list2", userDetailsServiceImpl.getGenderList()));
    }
//OK

    /**
     * Update user post model and view.
     *
     * @param user  the user
     * @param model the model
     * @return the model and view
     */
    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updateUserPost(@Valid User user, ModelMap model) {
        viewName = "user/updateUser";
        model.addAttribute("user", user).addAttribute("list3", userDetailsServiceImpl.getRoleList()).addAttribute("list2", userDetailsServiceImpl.getGenderList());

        if (user.getId() == null) {
            return getStandardCustomModel(viewName, model, "User ID Is Null");
        }
        if (user.getName() == null) {
            return getStandardCustomModel(viewName, model, "User Name Is Null");
        }
        if (user.getLastName() == null) {
            return getStandardCustomModel(viewName, model, "User Last Name Is Null");
        }
        if (user.getEmail() == null) {
            return getStandardCustomModel(viewName, model, "User Email Is Null");
        }
        if (user.getPassword() == null) {
            return getStandardCustomModel(viewName, model, "User Password Is Null");
        }
        if (user.getName().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Name Is Empty");
        }
        if (user.getLastName().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Last Name Is Empty");
        }
        if (user.getEmail().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Email Is Empty");
        }
        if (user.getPassword().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Password Is Empty");
        }

        if (!Validator.validName(user.getName())) {
            return getStandardCustomModel(viewName, model, "Invalid Name Value");
        }
        if (!Validator.validName(user.getLastName())) {
            return getStandardCustomModel(viewName, model, "Invalid Last Name Value");
        }
        if (Validator.validEmail(user.getEmail())) {
            return getStandardCustomModel(viewName, model, "Invalid Email Value");
        }

        if (!userDetailsServiceImpl.getById(user.getId()).isPresent()) {
            return getStandardCustomModel(viewName, model, "User With The ID = " + user.getId() + ",\n Is Not Found");
        }
        for (User value : userDetailsServiceImpl.getAll()) {
            if (user.getEmail().equals(value.getEmail())) {
                return getStandardCustomModel(viewName, model, "The User With This Email Is Registered");
            }
        }

        user.setActive(true);
        user.setGender(user.getGender());
        user.setName(user.getName().toUpperCase());
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsServiceImpl.saveEntity(user);
        return customModelOk("user/user", model, "User Updated");
    }
}