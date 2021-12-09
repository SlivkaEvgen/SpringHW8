package org.goit.springhw8.controller;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.goit.springhw8.model.dto.UserDto;
import org.goit.springhw8.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@Logger
@RestController
@RequestMapping("registration")
public class Registration {

    private final UserService userService;

    public Registration(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

//    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
//                                            HttpServletRequest request, Errors errors) {
//        return new ModelAndView();
//    }

}
