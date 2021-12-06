package org.goit.springhw8.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public ModelAndView loginGet(ModelMap modelMap, @ModelAttribute String name, @ModelAttribute String password) {
        System.out.println("username " + name);
        System.out.println("password " + password);
        return new ModelAndView("login", modelMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView loginPost(ModelMap modelMap, String name, String password) {
        System.out.println(" loginPost username " + name);
        System.out.println("loginPost password " + password);
        return new ModelAndView("login", modelMap);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("logoutPage");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
