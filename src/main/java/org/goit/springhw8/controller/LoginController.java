package org.goit.springhw8.controller;

import org.goit.springhw8.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public ModelAndView loginGet(ModelMap modelMap, @ModelAttribute String name, @ModelAttribute String password) {
        System.out.println("Lo0gin get " + modelMap);
        System.out.println("username " + name);
        System.out.println("password " + password);
        return new ModelAndView("login", modelMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView loginPost(ModelMap modelMap,@ModelAttribute String name,@ModelAttribute String password,@AuthenticationPrincipal User user){
        System.out.println("RequestMapping get modelMap = "+modelMap);
        System.out.println("username "+name);
        System.out.println("password "+password);
        return new ModelAndView("login",modelMap);
    }

}
