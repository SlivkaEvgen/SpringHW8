//package org.goit.springhw8.controller;
//
//import org.goit.springhw8.service.UserService;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class AdminController {
//
//    private final UserService userService;
//
//    public AdminController(UserService userService) {
//        this.userService=userService;
//    }
//
//    @GetMapping("admin")
//    public String userList(@NotNull Model model) {
//        System.out.println("AdminController userList");
//        model.addAttribute("allUsers", userService.getList());
//        return "admin";
//    }
//
//    @PostMapping("admin")
//    public String  deleteUser(@RequestParam(defaultValue = "" ) String userId,
//                              @NotNull @RequestParam(defaultValue = "" ) String action,
//                              Model model) {
//        System.out.println("AdminController deleteUser "+model);
//
//        if (action.equals("delete")){
//            userService.deleteById(userId);
//        }
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/admin/gt/{userId}")
//    public String  gtUser(@PathVariable("userId") String userId, @NotNull Model model) {
//        System.out.println("AdminController gtUser");
//        model.addAttribute("allUsers", userService.getById(userId));
//        return "admin";
//    }
//}
