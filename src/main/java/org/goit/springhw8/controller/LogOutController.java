package org.goit.springhw8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Log out controller.
 */
@Controller
@RequestMapping("logout")
public class LogOutController {

    /**
     * Login page model and view.
     *
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("logout");
    }
}
