package org.goit.springhw8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap model) {
        if (model==null){
            return new ModelAndView("login");
        }
        return new ModelAndView("login", model);
    }

}
