package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Login controller.
 */
@Controller
@Validated
@RequestMapping("login")
public class LoginController {

    /**
     * Login page model and view.
     *
     * @param model the model
     * @param user  the user
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap model,@Valid UserDto user) {
        return new ModelAndView("login", model.addAttribute("user",user));
    }

}
