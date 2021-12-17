package org.goit.springhw8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("logout")
public class LogOutController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap model) {
        return new ModelAndView("logout");
    }
}
