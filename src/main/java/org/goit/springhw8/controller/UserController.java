package org.goit.springhw8.controller;

import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.goit.springhw8.util.SendErrorMessage;
import org.goit.springhw8.util.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private final SendErrorMessage sendErrorMessage;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final SetIntoUser setIntoUser;

    private String viewName = "";

    public UserController(SendErrorMessage sendErrorMessage, UserDetailsServiceImpl userDetailsServiceImpl, SetIntoUser setIntoUser) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.sendErrorMessage = sendErrorMessage;
        this.setIntoUser = setIntoUser;
    }

    public ModelAndView customModel(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModel(viewName, model, message);
    }

    public ModelAndView customModelOk(String viewName, ModelMap model, Object errorMessage) {
        return sendErrorMessage.customModelOK(viewName, model, errorMessage);
    }

    @GetMapping("user")
    public ModelAndView entityUser(ModelMap model) {
        return new ModelAndView("user/user", model);
    }

    @GetMapping("list")
    public ModelAndView getAllUsers(ModelMap model) {
        return new ModelAndView("user/list", String.valueOf(model), model.addAttribute("list", userDetailsServiceImpl.getAll()));
    }

    @GetMapping("id")
    public ModelAndView getUserById(String id, ModelMap model) {
        viewName = "user/userById";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!userDetailsServiceImpl.getById(id).isPresent()) {
            return customModel(viewName, model.addAttribute("list", userDetailsServiceImpl.findListByEntityId(id)), "User With The ID = " + id + ",\n Is Not Found");
        }
        return customModelOk(viewName, model.addAttribute("list", userDetailsServiceImpl.findListByEntityId(id)), "");
    }

    @GetMapping("name")
    public ModelAndView getUserByName(String name, ModelMap model) {
        viewName = "user/userByName";
        if (name == null) {
            return new ModelAndView(viewName, model);
        }
        if (userDetailsServiceImpl.findByName(name).isEmpty()) {
            return customModel(viewName, model.addAttribute("list", userDetailsServiceImpl.findListByEntityId(name)), "User With The Name = " + name + ",\n Is Not Found");
        }
        return customModelOk(viewName, model.addAttribute("list", userDetailsServiceImpl.findByName(name)), "");
    }

    @GetMapping("email")
    public ModelAndView getUserByEmail(String email, ModelMap model) {
        viewName = "user/userByEmail";
        if (email == null) {
            return new ModelAndView(viewName, model);
        }
        if (userDetailsServiceImpl.findByEmail(email).isEmpty()) {
            return customModel(viewName, model.addAttribute("list", userDetailsServiceImpl.findByEmail(email)), "User With The Name = " + email + ",\n Is Not Found");
        }
        return customModelOk(viewName, model.addAttribute("list", userDetailsServiceImpl.findByEmail(email)), "");
    }

    @GetMapping("delete")
    public ModelAndView deleteUserById(String id, ModelMap model) {
        viewName = "user/deleteUser";
        if (id == null) {
            return new ModelAndView(viewName, model);
        }
        if (!userDetailsServiceImpl.getById(id).isPresent()) {
            return customModel(viewName, model, "User With The ID = " + id + ",\n Is Not Found");
        }
        // if ADMIN
        if (id.equalsIgnoreCase("1")) {
            return customModel(viewName, model, "Forbidden! User ADMIN ");
        }
        userDetailsServiceImpl.deleteById(id);
        return customModelOk("user/user", model, "User Deleted");
    }

    @GetMapping("new/**")
    public ModelAndView addNewUserGet(User user, ModelMap model) {
        return new ModelAndView("user/newUser", String.valueOf(model), model.addAttribute("user", user).addAttribute("list2", userDetailsServiceImpl.getGenderList()).addAttribute("list3", userDetailsServiceImpl.getRoleList()));
    }

    @RequestMapping(value = "new/**", method = RequestMethod.POST)
    public ModelAndView addNewUserPost(User user, ModelMap model) {
        viewName = "user/newUser";
        if (model == null) {
            return new ModelAndView("user/newUser");
        }
        model.addAttribute("list2", userDetailsServiceImpl.getGenderList());// .addAttribute("list3", userDetailsServiceImpl.getRoleList());
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(String.valueOf(UUID.randomUUID()));
        }
        if (!setIntoUser.NotNullNotEmpty(viewName, user, model).isEmpty()) {
            if (!Validator.validName(user.getName())) {
                return customModel(viewName, model, " Invalid  Name ");
            }
            if (!Validator.validName(user.getLastName())) {
                return customModel(viewName, model, " Invalid  Last Name ");
            }
            if (Validator.validEmail(user.getEmail())) {
                return customModel(viewName, model, " Invalid  Email ");
            }
            if (!userDetailsServiceImpl.findByEmail(user.getEmail()).isEmpty()) {
                return customModel(viewName, model, "The User With This Email Is Registered");
            }
            if (user.getPassword().length() <= 5 | user.getPassword().length() > 20) {
                return customModel(viewName, model, " Password must be more than 5 characters ");
            }
            if (userDetailsServiceImpl.getById(user.getId()).isPresent()) {
                return customModel(viewName, model, "User With ID " + user.getId() + "Is Used");
            }
        }
        userDetailsServiceImpl.saveEntity(setIntoUser.setUser(user));
        return customModelOk("user/user", model, "User Is Registered.\n Now You Can To Log In");
    }

    @GetMapping("update/**")
    public ModelAndView updateUserGet(User user, ModelMap model) {
        return new ModelAndView("user/updateUser", String.valueOf(model), model.addAttribute("user", user).addAttribute("list3", userDetailsServiceImpl.getRoleList()).addAttribute("list2", userDetailsServiceImpl.getGenderList()));
    }

    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updateUserPost(User user, ModelMap model) {
        viewName = "user/updateUser";
        if (model == null) {
            return new ModelAndView("user/updateUser");
        }
        model.addAttribute("user", user).addAttribute("list2", userDetailsServiceImpl.getGenderList());//addAttribute("list3", userDetailsServiceImpl.getRoleList()).
        if (user.getId() == null || user.getId().isEmpty()) {
            return customModel(viewName, model, "User ID Is Null Or Empty");
        }
        if (!setIntoUser.NotNullNotEmpty(viewName, user, model).isEmpty()) {
            if (!Validator.validName(user.getName())) {
                return customModel(viewName, model, "Invalid Name Value");
            }
            if (!Validator.validName(user.getLastName())) {
                return customModel(viewName, model, "Invalid Last Name Value");
            }
            if (Validator.validEmail(user.getEmail())) {
                return customModel(viewName, model, "Invalid Email Value");
            }
            // if by id is Empty
            if (!userDetailsServiceImpl.getById(user.getId()).isPresent()) {
                return customModel(viewName, model, "User With The ID = " + user.getId() + ",\n Is Not Found");
            }
            // check unique email
            if (!userDetailsServiceImpl.findByEmail(user.getEmail()).isEmpty()) {
                return customModel(viewName, model, "The User With This Email Is Registered");
            }
            // if ADMIN
            if (user.getId().equalsIgnoreCase("1")) {
                return customModel(viewName, model, "Forbidden! User ADMIN ");
            }
        }
        userDetailsServiceImpl.saveEntity(setIntoUser.setUser(user));
        return customModelOk("user/user", model, "User Updated");
    }
}