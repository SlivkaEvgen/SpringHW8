package org.goit.springhw8.controller;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.goit.springhw8.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Admin controller.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    /**
     * Login page model and view.
     *
     * @param model the model
     * @param user  the user
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap model,  User user) {
        return new ModelAndView("admin", String.valueOf(model),model.addAttribute("user",user));
    }
}
