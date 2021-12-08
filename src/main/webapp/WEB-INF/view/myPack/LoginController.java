//package org.goit.springhw8.controller;

//import lombok.extern.log4j.Log4j2;
//import org.goit.springhw8.model.User;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Map;

//@Log4j2
//@Controller
//@RequestMapping("login")
//public class LoginController implements UserDetailsService {

//    @GetMapping
//    public ModelAndView loginGet(ModelMap model, User user) {
//        return new ModelAndView("login", model.addAttribute("user", user));
//    }

//    @RequestMapping(value = "",method = RequestMethod.POST)
//    public ModelAndView loginPost(ModelMap model, @AuthenticationPrincipal User user) {
//        System.out.println(" loginPost User ");
////        model.addAttribute("username", user.getName());
////        model.addAttribute("password", user.getPassword());
////        model.addAttribute("user", user);
//        UserDetails userDetails = loadUserByUsername(user.getName());
//        return new ModelAndView("login", model.addAttribute("user", userDetails));
//    }

//    @RequestMapping(value = "logout",method = RequestMethod.GET)
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("logoutPage");
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/";
//    }

//    @RequestMapping(method = RequestMethod.POST)
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("username = "+username);
//        return null;
//    }
//}
