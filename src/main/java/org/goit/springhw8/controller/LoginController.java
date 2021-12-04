package org.goit.springhw8.controller;

import com.sun.tracing.dtrace.ModuleAttributes;
import org.goit.springhw8.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public ModelAndView login(Model model, ModelMap modelMap,
                              @ModelAttribute String name, @ModelAttribute String password, BindingResult bindingResult, User user) {
        System.out.println("Lo0gin get " + modelMap);
        System.out.println("username " + name);
        System.out.println("password " + password);
        return new ModelAndView("login", modelMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login4(ModelMap modelMap, String name, String password){
        System.out.println("RequestMapping get modelMap = "+modelMap);
        System.out.println("username "+name);
        System.out.println("password "+password);
        return new ModelAndView("login",modelMap);
    }


}
