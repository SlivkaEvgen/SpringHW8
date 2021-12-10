package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserService;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Validated
@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public ModelAndView entityUser(ModelMap model) {
        return new ModelAndView("user/user", model);
    }

    @GetMapping("list")
    public ModelAndView getAllUsers(ModelMap model) {
        if (model==null){
            return new ModelAndView("user/list");
        }
        return new ModelAndView("user/list", model.addAttribute("list", userService.getAll()));
    }

    @GetMapping("id")
    public ModelAndView getUserById(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("user/userById", model);
        }
        if (id.isEmpty()) {
            return new ModelAndView("user/userById", model.addAttribute("id", id).addAttribute("error", " User ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
//        if (!Validator.validId(id)) {
//            return new ModelAndView("user/userById", model.addAttribute("id", id).addAttribute("model", model).addAttribute("error", "Wrong User ID " + id).addAttribute("error2", "Please, Try Again"));
        if (!userService.getById(id).isPresent()) {
            return new ModelAndView("user/userById", model.addAttribute("id", id).addAttribute("model", model).addAttribute("error", "Could Not Find By ID " + id).addAttribute("error2", "Please, Try Again"));
        }
        if (!userService.getById(id).isPresent()) {
            return new ModelAndView("user/userById", model.addAttribute("error2", "Is Empty"));
        }
        return new ModelAndView("user/userById", model.addAttribute("error2", "SUCCESSFULLY").addAttribute("list", userService.findListById(id)));

    }

    @GetMapping("name")
    public ModelAndView getUserByName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("user/userByName", model);
        }
        if (name.isEmpty()) {
            return new ModelAndView("user/userByName", model.addAttribute("name", name).addAttribute("model", model).addAttribute("error", " User Name Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validName(name)) {
            return new ModelAndView("user/userByName", model.addAttribute("name", name).addAttribute("model", model).addAttribute("error", " Wrong User Name ").addAttribute("error2", "Please, Try Again"));
        }
        if (!userService.findByName(name).isPresent()) {
            return new ModelAndView("user/userByName", model.addAttribute("name", name).addAttribute("model", model).addAttribute("error", "Could Not Find By Name " + name).addAttribute("error2", "Please, Try Again"));
        }
        return new ModelAndView("user/userByName", model.addAttribute("error2", "SUCCESSFULLY").addAttribute("list", Collections.singletonList(userService.findByName(name).get())));
    }

    @GetMapping("delete")
    public ModelAndView deleteUserById(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("user/deleteUser", model);
        }
        if (id.isEmpty()) {
            return new ModelAndView("user/deleteUser", model.addAttribute("error", " User ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("user/deleteUser", model.addAttribute("id", id).addAttribute("error", "Wrong User ID").addAttribute("error2", "Please, Try Again"));
        }
        if (!userService.getById(id).isPresent()) {
            return new ModelAndView("user/deleteUser", model.addAttribute("id", id).addAttribute("error", "User With ID = " + id + " Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (userService.getById(id).get().getName().equalsIgnoreCase("admin")) {
            return new ModelAndView("user/deleteUser", model.addAttribute("id", id).addAttribute("error", "Sorry, You Cannot Delete The Administrator").addAttribute("error2", "Please, Try Again"));
        }
        userService.deleteById(id);
        return new ModelAndView("user/user", model.addAttribute("error", "User Deleted").addAttribute("error2", "SUCCESSFULLY"));
    }

    @GetMapping("new/**")
    public ModelAndView addNewUserGet(@Valid User user, ModelMap model) {
        if (model==null){
            return new ModelAndView("user/newUser");
        }
        return new ModelAndView("user/newUser", model.addAttribute("user", user).addAttribute("list2", userService.getGenderList()).addAttribute("list3", userService.getRoles()));
    }

    @RequestMapping(value = "new/**", method = RequestMethod.POST)
    public ModelAndView addNewUserPost(@Valid @ModelAttribute User user, ModelMap model) {
        if (model==null){
            return new ModelAndView("user/newUser");
        }
        model.addAttribute("user", user).addAttribute("list3", userService.getRoles()).addAttribute("list2", userService.getGenderList());
        if (user==null){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getId() == null) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getName() == null) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getPassword() == null) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getGender() == null) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getEmail() == null) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getLastName() == null) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getRoles() == null) {
            return new ModelAndView("user/newUser", model);
        }

        if (user.getId().isEmpty()) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getName().isEmpty()) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getPassword().isEmpty()) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getGender().name().isEmpty()) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getEmail().isEmpty()) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getLastName().isEmpty()) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getRoles().isEmpty()) {
            return new ModelAndView("user/newUser", model);
        }

        if (!Validator.validId(user.getId())) {
            return new ModelAndView("user/newUser", model);
        }
        if (!Validator.validName(user.getName())) {
            return new ModelAndView("user/newUser", model);
        }
        if (!Validator.validName(user.getLastName())) {
            return new ModelAndView("user/newUser", model);
        }
        if (!Validator.validEmail(user.getEmail())) {
            return new ModelAndView("user/newUser", model);
        }
        if (!Validator.validGender(user.getGender().name())) {
            return new ModelAndView("user/newUser", model);
        }

        user.setName(user.getName().toUpperCase());
        userService.saveUser(user);
        return new ModelAndView("user/user", model.addAttribute("user", model.addAttribute("error", "User Added").addAttribute("error2", "SUCCESSFULLY")));
    }

    @GetMapping("update/**")
    public ModelAndView updateUserGet(@Valid User user, ModelMap model) {
        if (model==null){
            return new ModelAndView("user/updateUser");
        }
        return new ModelAndView("user/updateUser", model.addAttribute("user", user).addAttribute("list3", userService.getRoles()).addAttribute("list2", userService.getGenderList()));
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updateUserPost(@Valid User user, ModelMap model) {
        if (model==null){
            return new ModelAndView("user/updateUser");
        }
        model.addAttribute("user", user).addAttribute("list3", userService.getRoles()).addAttribute("list2", userService.getGenderList());
        if (user == null) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getId() == null) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getName() == null) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getPassword() == null) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getGender() == null) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getEmail() == null) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getLastName() == null) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getRoles() == null) {
            return new ModelAndView("user/updateUser", model);
        }

        if (user.getId().isEmpty()) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getName().isEmpty()) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getPassword().isEmpty()) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getGender().name().isEmpty()) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getEmail().isEmpty()) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getLastName().isEmpty()) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getRoles().isEmpty()) {
            return new ModelAndView("user/updateUser", model);
        }

        if (!Validator.validId(user.getId())) {
            return new ModelAndView("user/updateUser", model);
        }
        if (!Validator.validName(user.getName())) {
            return new ModelAndView("user/updateUser", model);
        }
        if (!Validator.validName(user.getLastName())) {
            return new ModelAndView("user/updateUser", model);
        }
        if (!Validator.validEmail(user.getEmail())) {
            return new ModelAndView("user/updateUser", model);
        }
        if (!Validator.validGender(user.getGender().name())) {
            return new ModelAndView("user/updateUser", model);
        }

        if (user.getName().equalsIgnoreCase("role_admin")) {
            return new ModelAndView("user/updateUser", model.addAttribute("error", "Sorry, You Cannot Update The Administrator").addAttribute("error2", "Please,Try again"));
        }

        user.setName(user.getName().toUpperCase());
        userService.saveUser(user);
        return new ModelAndView("user/user", model.addAttribute("user", user).addAttribute("error", "User Updated").addAttribute("error2", "SUCCESSFULLY"));
    }
}