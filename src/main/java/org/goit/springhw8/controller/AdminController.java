package org.goit.springhw8.controller;

import com.zaxxer.hikari.pool.HikariPool;
import jakarta.validation.Valid;
import org.goit.springhw8.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap model, @Valid User user) {
        return new ModelAndView("admin", model.addAttribute("user",user));
    }
}
