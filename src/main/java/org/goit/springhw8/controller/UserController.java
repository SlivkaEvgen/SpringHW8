package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.goit.springhw8.util.SendError;
import org.goit.springhw8.util.Validator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

/**
 * The type User controller.
 */
//@Validated
@Controller
@RequestMapping(value = "user")
public class UserController {

    private final SendError sendError;
    private final Registration registration;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final PasswordEncoder passwordEncoder;
    private String viewName = "";

    /**
     * Instantiates a new User controller.
     *
     * @param userDetailsServiceImpl the my user details service
     */
    public UserController(SendError sendError, UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder passwordEncoder, Registration registration) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.registration = registration;
        this.sendError = sendError;
    }

    public ModelAndView getFullCustomModel(String viewName, ModelMap model, User user, Object message) {
        return sendError.customModelUser(viewName, model, user, message);
    }

    public ModelAndView getStandardCustomModel(String viewName, ModelMap model, Object message) {
        return sendError.customModelUserStandard(viewName, model, message);
    }

    public ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendError.customModelUserOK(viewName, model, errorMessage);
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
    public ModelAndView getAllUsers(ModelMap model) {
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
            return valid(viewName, model, id);
        }
        valid(viewName, model, id);
//        if (id == null) {
//            return getStandardCustomModel(viewName, model, "");
//        }
//        if (id.isEmpty()) {
//            return getStandardCustomModel(viewName, model, " User ID Is Empty");
//        }
        if (!userDetailsServiceImpl.getById(id).isPresent()) {
            return getStandardCustomModel(viewName, model, "Could Not Find By ID " + id);
        }
        if (!userDetailsServiceImpl.getById(id).isPresent()) {
            return getStandardCustomModel(viewName, model, "User Is Empty");
        }
        return customModelOk("user/userById", model.addAttribute("list", userDetailsServiceImpl.findListByEntityId(id)), "");
    }

    public ModelAndView valid(String viewName, ModelMap model, String param) {
        if (model != null) {
            return new ModelAndView(viewName, model);
        }
        if (model.isEmpty()) {
            return getStandardCustomModel(viewName, model, "");
        }
        if (param == null) {
            return getStandardCustomModel(viewName, model, param + "Is Null");
        }
        if (param.isEmpty()) {
            return getStandardCustomModel(viewName, model, param + "Is Empty");
        }
        if (param.equalsIgnoreCase("name")) {
            if (!Validator.validName(param)) {
                return getStandardCustomModel(viewName, model, " Invalid User Name ");
            }
        }
        return getStandardCustomModel(viewName, model, "");
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
            return valid(viewName, model, name);
        }
        valid(viewName, model, name);
//        if (name == null) {
//            return new ModelAndView(viewName, model);
//        }
//        if (name.isEmpty()) {
//            return getStandardCustomModel(viewName, model, " User Name Is Empty");
//        }
//        if (!Validator.validName(name)) {
//            return getStandardCustomModel(viewName, model, " Invalid User Name ");
//        }
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
//        if (!Validator.validId(id)) {
//            return getStandardCustomModel(viewName, model, "Invalid ID Value");
//        }
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
        return new ModelAndView("user/newUser", model.addAttribute("SUCCESSFULLY").addAttribute("user", user).addAttribute("list2", userDetailsServiceImpl.getGenderList()).addAttribute("list3", userDetailsServiceImpl.getRoles()));
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
        return registration.registration(user, model.addAttribute("SUCCESSFULLY"));
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
        return new ModelAndView("user/updateUser", model.addAttribute("user", user).addAttribute("list3", userDetailsServiceImpl.getRoles()).addAttribute("list2", userDetailsServiceImpl.getGenderList()));
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
        model.addAttribute("user", user).addAttribute("list3", userDetailsServiceImpl.getRoles()).addAttribute("list2", userDetailsServiceImpl.getGenderList());

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