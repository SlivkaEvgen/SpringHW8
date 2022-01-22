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

/**
 * The type Registration.
 */
@RestController
@RequestMapping("registration")
public class Registration {

    private final SendErrorMessage sendErrorMessage;

    private final SetIntoUser setIntoUser;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    /**
     * Instantiates a new Registration.
     *
     * @param userDetailsServiceImpl the user details service
     * @param sendErrorMessage       the send error message
     * @param setIntoUser            the set into user
     */
    public Registration(UserDetailsServiceImpl userDetailsServiceImpl, SendErrorMessage sendErrorMessage,SetIntoUser setIntoUser) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.sendErrorMessage = sendErrorMessage;
        this.setIntoUser=setIntoUser;
    }

    /**
     * Custom model model and view.
     *
     * @param viewName the view name
     * @param model    the model
     * @param message  the message
     * @return the model and view
     */
    public ModelAndView customModel(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModel(viewName, model, message);
    }

    /**
     * Custom model ok model and view.
     *
     * @param viewName the view name
     * @param model    the model
     * @param message  the message
     * @return the model and view
     */
    public ModelAndView customModelOK(String viewName, ModelMap model, Object message) {
        return sendErrorMessage.customModelOk(viewName, model, message);
    }

    /**
     * Registration get model and view.
     *
     * @param model the model
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registrationGet(ModelMap model) {
        return new ModelAndView("registration", String.valueOf(model), model.addAttribute("list", userDetailsServiceImpl.getGenderList()));
    }

    /**
     * Registration post model and view.
     *
     * @param user  the user
     * @param model the model
     * @return the model and view
     */
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

