package org.goit.springhw8.controller;

import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.goit.springhw8.util.SendErrorMessage;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@RestController
@RequestMapping("registration")
public class Registration {

    private final SendErrorMessage sendErrorMessage;

    private final SetIntoUser setIntoUser;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public Registration(UserDetailsServiceImpl userDetailsServiceImpl, SendErrorMessage sendErrorMessage,SetIntoUser setIntoUser) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.sendErrorMessage = sendErrorMessage;
        this.setIntoUser=setIntoUser;
    }

    public ModelAndView customModel(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModel(viewName, model, message);
    }

    public ModelAndView customModelOK(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModelOK(viewName, model, message);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registrationGet(ModelMap model) {
        return new ModelAndView("registration", String.valueOf(model), model.addAttribute("list", userDetailsServiceImpl.getGenderList()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registrationPost(User user, ModelMap model) {
        String viewName = "registration";
        if (model == null) {
            return new ModelAndView("registration");
        }
        model.addAttribute("list", userDetailsServiceImpl.getGenderList());
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(String.valueOf(UUID.randomUUID()));
        }
        if (!setIntoUser.NotNullNotEmpty(viewName,user,model).isEmpty()) {
            if (!userDetailsServiceImpl.findByEmail(user.getEmail()).isEmpty()) {
                return customModel(viewName, model, "The User With This Email Is Registered");
            }
        }
        userDetailsServiceImpl.saveEntity(setIntoUser.setUser(user));
        return customModelOK("login", model, "User Is Registered.\n Now You Can To Log In");
    }
}

