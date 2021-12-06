package org.goit.springhw8.controller;

import org.goit.springhw8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("admin")
    public String userList(Model model) {
        System.out.println("AdminController userList");
        model.addAttribute("allUsers", userService.getList());
        return "admin";
    }

    @PostMapping("admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) String userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        System.out.println("AdminController deleteUser");

        if (action.equals("delete")){
            userService.deleteById(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") String userId, Model model) {
        System.out.println("AdminController gtUser");
        model.addAttribute("allUsers", userService.getById(userId));
        return "admin";
    }
}
