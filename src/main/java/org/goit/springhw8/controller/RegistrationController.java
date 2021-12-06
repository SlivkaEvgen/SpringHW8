package org.goit.springhw8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    @GetMapping
    public ModelAndView registrationGet(ModelMap modelMap, @ModelAttribute String name, @ModelAttribute String password) {
        System.out.println("Lo0gin get " + modelMap);
        System.out.println("username " + name);
        System.out.println("password " + password);
        return new ModelAndView("registration", modelMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registrationPost(ModelMap modelMap, @ModelAttribute String name, @ModelAttribute String password) {
        System.out.println("RequestMapping get modelMap = " + modelMap);
        System.out.println("username " + name);
        System.out.println("password " + password);
        return new ModelAndView("registration", modelMap);
    }

}
