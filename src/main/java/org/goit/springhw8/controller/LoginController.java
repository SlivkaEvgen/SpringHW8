package org.goit.springhw8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelMap loginPage(Model model) {
        return new ModelMap("login", model);
    }

}
