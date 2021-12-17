package org.goit.springhw8.controller;

import org.goit.springhw8.model.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap model,UserDto user) {
        return new ModelAndView("login", String.valueOf(model),model.addAttribute("user",user));
    }
}
