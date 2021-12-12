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

    public ModelAndView getFullCustomModel(String viewName, ModelMap model, User user, Object message) {
        return sendErrorMessage.customModelUser(viewName, model, user, message);
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
            return getStandardCustomModel(viewName, model, "Could Not Find By ID " + id);
        }
        if (!userDetailsServiceImpl.getById(id).isPresent()) {
            return getStandardCustomModel(viewName, model, "User Is Empty");
        }
        return customModelOk("user/userById", model.addAttribute("list", userDetailsServiceImpl.findListByEntityId(id)), "");
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
        if (name.isEmpty()) {
            return getStandardCustomModel(viewName, model, " User Name Is Empty");
        }
        if (!Validator.validName(name)) {
            return getStandardCustomModel(viewName, model, " Invalid User Name ");
        }
        if (userDetailsServiceImpl.findByName(name).isEmpty()) {
            return getStandardCustomModel(viewName, model, "Could Not Find By Name " + name);
        }
        return customModelOk("user/userByName", model.addAttribute("list", userDetailsServiceImpl.findByName(name)), "");
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
        if (!Validator.validId(id)) {
            return getStandardCustomModel(viewName, model, "Invalid ID Value");
        }
        if (!userDetailsServiceImpl.getById(id).isPresent()) {
            return getStandardCustomModel(viewName, model, "Manufacturer With ID = " + id + " Not Found");
        }
//        if (id.isEmpty()) {
//            return getStandardCustomModel(viewName, model, " User ID Is Empty");
//        }
//        Optional<User> optionalUser = myUserDetailsService.getById(id);
//        System.out.println(optionalUser);

//        if (optionalUser.get().getName().equalsIgnoreCase("admin")) {
//            return getStandardCustomModel(viewName, model, "Sorry, You Cannot Delete The Administrator");
//        }
//        if (optionalUser.isPresent()) {
//            return getStandardCustomModel(viewName, model, "User With ID = " + id + " Is Empty");
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
        return new ModelAndView("user/newUser", model.addAttribute("user", user).addAttribute("list2", userDetailsServiceImpl.getGenderList()).addAttribute("list3",userDetailsServiceImpl.getRoleList()));
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
    public ModelAndView registration(@Valid User user, ModelMap model) {
        viewName="user/newUser";
        model.addAttribute("list2", userDetailsServiceImpl.getGenderList());
        model.addAttribute("list3",userDetailsServiceImpl.getRoleList());
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
        if (user.getName().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Name Is Empty");
        }
        if (user.getLastName() == null) {
            return getStandardCustomModel(viewName, model, "User Last Name Is Null");
        }
        if (user.getLastName().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Last Name Is Empty");
        }
        if (user.getEmail().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Email Is Empty");
        }
        if (user.getEmail() == null) {
            return getStandardCustomModel(viewName, model, "User Email Is Null");
        }
        if (user.getPassword().isEmpty()) {
            return getStandardCustomModel(viewName, model, "User Password Is Empty");
        }
        if (user.getPassword() == null) {
            return getStandardCustomModel(viewName, model, "User Password Is Null");
        }
        for (User value : userDetailsServiceImpl.getAll()) {
            if (user.getEmail().equals(value.getEmail())) {
                return getStandardCustomModel(viewName, model, "The User With This Email Is Registered");
            }
        }

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
            return getFullCustomModel(viewName, model, user, "ERROR");
        }
        if (user.getPassword() == null) {
            return getFullCustomModel(viewName, model, user, "ERROR");
        }
        if (user.getEmail() == null) {
            return getFullCustomModel(viewName, model, user, "ERROR");
        }
        if (user.getLastName() == null) {
            return getFullCustomModel(viewName, model, user, "ERROR");
        }
        if (user.getEmail().isEmpty()) {
            return getFullCustomModel(viewName, model, user, "ERROR getEmail");
        }
        if (user.getLastName().isEmpty()) {
            return getFullCustomModel(viewName, model, user, "ERROR getLastName");
        }
        if (!Validator.validName(user.getName())) {
            return getFullCustomModel(viewName, model, user, "ERROR getName");
        }
        if (!Validator.validName(user.getLastName())) {
            return getFullCustomModel(viewName, model, user, "ERROR getLastName");
        }
        if (Validator.validEmail(user.getEmail())) {
            return getFullCustomModel(viewName, model, user, "ERROR getEmail");
        }

        if (!userDetailsServiceImpl.getById(user.getId()).isPresent()) {
            return getFullCustomModel(viewName, model, user, "NOT FOUND");
        }

        if (user.getName() == null) {
            return getFullCustomModel(viewName, model, user, "User Name Is Null");
        }
        if (user.getName().isEmpty()) {
            return getFullCustomModel(viewName, model, user, "User Name Is Empty");
        }
        if (user.getLastName() == null) {
            return getFullCustomModel(viewName, model, user, "User Name Is Null");
        }
        if (user.getLastName().isEmpty()) {
            return getFullCustomModel(viewName, model, user, "User Name Is Empty");
        }
        if (user.getEmail().isEmpty()) {
            return getFullCustomModel(viewName, model, user, "User Email Is Empty");
        }
        if (user.getEmail() == null) {
            return getFullCustomModel(viewName, model, user, "User Email Is Empty");
        }
        if (user.getPassword().isEmpty()) {
            return getFullCustomModel(viewName, model, user, "User Email Is Empty");
        }
        if (user.getPassword() == null) {
            return getFullCustomModel(viewName, model, user, "User Email Is Empty");
        }
        for (User value : userDetailsServiceImpl.getAll()) {
            if (user.getEmail().equals(value.getEmail())) {
                return getFullCustomModel(viewName, model, user, "The User With This Email Is Registered");
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