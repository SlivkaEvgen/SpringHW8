package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.MyUserDetailsService;
import org.goit.springhw8.util.Validator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type User controller.
 */
@Validated
@Controller
@RequestMapping(value = "user")
public class UserController {

    private final static String ERROR = "error";
    private final static String ERROR2 = "error2";
    private final static String ERROR2MESSAGE = "Please,Try Again";
    private final static String ERROR2SUCCESSFULLY = "SUCCESSFULLY";
    private String viewName = "";
    private PasswordEncoder passwordEncoder;

    public ModelAndView customModel(String viewName, ModelMap model, User user,Object message) {
        if (model != null) {
            return new ModelAndView(viewName, model.addAttribute("user",user).addAttribute(ERROR, message).addAttribute(ERROR2, ERROR2MESSAGE));
        }
        return new ModelAndView();
    }

    public ModelAndView customModelMini(String viewName, ModelMap model, Object errorMessage) {
        if (model != null) {
            return new ModelAndView(viewName, model.addAttribute(ERROR, errorMessage).addAttribute(ERROR2, ERROR2MESSAGE));
        }
        return new ModelAndView();
    }

    private final MyUserDetailsService myUserDetailsService;

    /**
     * Instantiates a new User controller.
     *
     * @param myUserDetailsService the my user details service
     */
    public UserController(MyUserDetailsService myUserDetailsService, PasswordEncoder passwordEncoder) {
        this.myUserDetailsService = myUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

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

    /**
     * Gets all users.
     *
     * @param model the model
     * @return the all users
     */
    @GetMapping("list")
    public ModelAndView getAllUsers(ModelMap model) {
        if (model == null) {
            return new ModelAndView("user/list");
        }
        return new ModelAndView("user/list", model.addAttribute("list", myUserDetailsService.getAll()));
    }

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
        if (id.isEmpty()) {
            customModelMini(viewName, model, " User ID Is Empty");
//            return new ModelAndView("user/userById", model.addAttribute("id", id).addAttribute("error", " User ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
//        if (!Validator.validId(id)) {
//            return new ModelAndView("user/userById", model.addAttribute("id", id).addAttribute("model", model).addAttribute("error", "Wrong User ID " + id).addAttribute("error2", "Please, Try Again"));
        if (!myUserDetailsService.getById(id).isPresent()) {
            customModelMini(viewName, model, "Could Not Find By ID " + id);
//            return new ModelAndView("user/userById", model.addAttribute("id", id).addAttribute("model", model).addAttribute("error", "Could Not Find By ID " + id).addAttribute("error2", "Please, Try Again"));
        }
        if (!myUserDetailsService.getById(id).isPresent()) {
            customModelMini(viewName, model, "User Is Empty");
//            return new ModelAndView("user/userById", model.addAttribute("error2", "Is Empty"));
        }
        return new ModelAndView("user/userById", model.addAttribute(ERROR2, ERROR2SUCCESSFULLY).addAttribute("list", myUserDetailsService.findListByEntityId(id)));

    }

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
            customModelMini(viewName, model, " User Name Is Empty");
//            return new ModelAndView("user/userByName", model.addAttribute("name", name).addAttribute("model", model).addAttribute("error", " User Name Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validName(name)) {
            customModelMini(viewName, model, " Wrong User Name ");
//            return new ModelAndView("user/userByName", model.addAttribute("name", name).addAttribute("model", model).addAttribute("error", " Wrong User Name ").addAttribute("error2", "Please, Try Again"));
        }
        if (myUserDetailsService.findByName(name).isEmpty()) {
            customModelMini(viewName, model, "Could Not Find By Name " + name);
//            return new ModelAndView("user/userByName", model.addAttribute("name", name).addAttribute("model", model).addAttribute("error", "Could Not Find By Name " + name).addAttribute("error2", "Please, Try Again"));
        }
        return new ModelAndView("user/userByName", model.addAttribute(ERROR2, ERROR2SUCCESSFULLY).addAttribute("list", myUserDetailsService.findByName(name)));
    }

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
        if (id.isEmpty()) {
            customModelMini(viewName, model, " User ID Is Empty");
//            return new ModelAndView("user/deleteUser", model.addAttribute("error", " User ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
//        if (!Validator.validId(id)) {
//            return new ModelAndView("user/deleteUser", model.addAttribute("id", id).addAttribute("error", "Wrong User ID").addAttribute("error2", "Please, Try Again"));
//        }
        if (!myUserDetailsService.getById(id).isPresent()) {
            customModelMini(viewName, model, "User With ID = " + id + " Is Empty");
//            return new ModelAndView("user/deleteUser", model.addAttribute("id", id).addAttribute("error", "User With ID = " + id + " Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (myUserDetailsService.getById(id).get().getName().equalsIgnoreCase("admin")) {
            customModelMini(viewName, model, "Sorry, You Cannot Delete The Administrator");
//            return new ModelAndView("user/deleteUser", model.addAttribute("id", id).addAttribute("error", "Sorry, You Cannot Delete The Administrator").addAttribute("error2", "Please, Try Again"));
        }
        myUserDetailsService.deleteById(id);
        return new ModelAndView("user/user", model.addAttribute(ERROR, "User Deleted").addAttribute(ERROR2, ERROR2MESSAGE));
    }

    /**
     * Add new user get model and view.
     *
     * @param user  the user
     * @param model the model
     * @return the model and view
     */
    @GetMapping("new/**")
    public ModelAndView addNewUserGet(@Valid User user, ModelMap model) {
        if (model == null) {
            return new ModelAndView("user/newUser");
        }
        return new ModelAndView("user/newUser", model.addAttribute("user", user).addAttribute("list2", myUserDetailsService.getGenderList()).addAttribute("list3", myUserDetailsService.getRoles()));
    }

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
        UUID randomUUID = UUID.randomUUID();

        if (user.getId() == null) {
            user.setId(String.valueOf(randomUUID));
        }
        if (user.getId().isEmpty()) {
            user.setId(String.valueOf(randomUUID));
        }
        if (user.getName() == null) {
            return customModel(viewName, model, user, "User Name Is Null");
        }
        if (user.getName().isEmpty()) {
            return customModel(viewName, model, user, "User Name Is Empty");
        }

        model.addAttribute("list3", myUserDetailsService.getRoles()).addAttribute("list2", myUserDetailsService.getGenderList());
        if (myUserDetailsService.getById(user.getId()).isPresent()) {
            return customModel(viewName, model, user, "User With ID " + user.getId() + "Is Used");
        }

//        if (user.getId() != null) {
//             validAddAndUpdate(viewName, user, model.addAttribute(ERROR2, ERROR2SUCCESSFULLY).addAttribute(ERROR, "User Is Registered.\n Now You Need To Log In")));
//        }

        user.setActive(true);
        if (user.isActive()){
            return validAddAndUpdate(viewName, user, model);
        }
//        myUserDetailsService.saveEntity(user);
        return new ModelAndView("user/user",model.addAttribute(ERROR2, ERROR2SUCCESSFULLY).addAttribute(ERROR, "User Is Registered.\n Now You Need To Log In"));
    }

    /**
     * Update user get model and view.
     *
     * @param user  the user
     * @param model the model
     * @return the model and view
     */
    @GetMapping("update/**")
    public ModelAndView updateUserGet(@Valid User user, ModelMap model) {
        if (model == null) {
            return new ModelAndView("user/updateUser");
        }
        return new ModelAndView("user/updateUser", model.addAttribute("user", user).addAttribute("list3", myUserDetailsService.getRoles()).addAttribute("list2", myUserDetailsService.getGenderList()));
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
        if (user.getId() == null) {
            return customModel(viewName, model, user, "ERROR");
        }
        if (model == null) {
            return customModel(viewName, null, user, "ERROR");
        }
        model.addAttribute("user", user).addAttribute("list3", myUserDetailsService.getRoles()).addAttribute("list2", myUserDetailsService.getGenderList());
        validAddAndUpdate(viewName, user, model);

        if (user.getPassword() == null) {
            return customModel(viewName, model, user, "ERROR");
        }
        if (user.getGender() == null) {
            return customModel(viewName, model, user, "ERROR");
        }
        if (user.getEmail() == null) {
            return customModel(viewName, model, user, "ERROR");
        }
        if (user.getLastName() == null) {
            return customModel(viewName, model, user, "ERROR");
        }
        if (user.getRoles() == null) {
            return customModel(viewName, model, user, "ERROR getRoles");
        }

        if (user.getPassword().isEmpty()) {
            return customModel(viewName, model, user, "ERROR getPassword");
        }
        if (user.getGender().name().isEmpty()) {
            return customModel(viewName, model, user, "ERROR getGender");
        }
        if (user.getEmail().isEmpty()) {
            return customModel(viewName, model, user, "ERROR getEmail");
        }
        if (user.getLastName().isEmpty()) {
            return customModel(viewName, model, user, "ERROR getLastName");
        }
        if (user.getRoles().isEmpty()) {
            return customModel(viewName, model, user, "ERROR getRoles");
        }
        if (!Validator.validId(user.getId())) {
            return customModel(viewName, model, user, "ERROR getId");
        }
        if (!Validator.validName(user.getName())) {
            return customModel(viewName, model, user, "ERROR getName");
        }
        if (!Validator.validName(user.getLastName())) {
            return customModel(viewName, model, user, "ERROR getLastName");
        }
        if (!Validator.validEmail(user.getEmail())) {
            return customModel(viewName, model, user, "ERROR getEmail");
        }


        if (!myUserDetailsService.getById(user.getId()).isPresent()) {
            return customModel(viewName, model, user, "NOT FOUND");
        }
        if (user.getRoles().contains(Role.ROLE_ADMIN)) {
            return customModel(viewName, model, user, "Sorry, You Cannot Update The Administrator");
        }
        user.setActive(true);
        myUserDetailsService.saveEntity(user);
        return new ModelAndView("user/user", model.addAttribute("user", user).addAttribute(ERROR, "User Updated").addAttribute(ERROR2, ERROR2SUCCESSFULLY));
    }

    public ModelAndView validAddAndUpdate(String viewName, User user, ModelMap model) {
        if (user.getName() == null) {
            return customModel(viewName, model, user, "User Name Is Null");
        }
        if (user.getName().isEmpty()) {
            return customModel(viewName, model, user, "User Name Is Empty");
        }
        if (user.getLastName() == null) {
            return customModel(viewName, model, user, "User Name Is Null");
        }
        if (user.getLastName().isEmpty()) {
            return customModel(viewName, model, user, "User Name Is Empty");
        }
        if (user.getEmail().isEmpty()) {
            return customModel(viewName, model, user, "User Email Is Empty");
        }
        if (user.getEmail() == null) {
            return customModel(viewName, model, user, "User Email Is Empty");
        }
        if (user.getPassword().isEmpty()) {
            return customModel(viewName, model, user, "User Email Is Empty");
        }
        if (user.getPassword() == null) {
            return customModel(viewName, model, user, "User Email Is Empty");
        }
        List<User> userList = myUserDetailsService.getAll();
        for (User value : userList) {
            if (user.getEmail().equals(value.getEmail())) {
                return customModel(viewName, model, user, "The User With This Email Is Registered");
            }
        }
        user.setGender(user.getGender());
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.setName(user.getName().toUpperCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        myUserDetailsService.saveEntity(user);
        return customModel("user/user",model.addAttribute(ERROR2, ERROR2SUCCESSFULLY).addAttribute(ERROR, "User Is Registered.\n Now You Need To Log In"), user,"OK 200");
    }
}