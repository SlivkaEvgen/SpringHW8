package org.goit.springhw8.controller;

import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserService;
import org.goit.springhw8.util.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

//@Validated
@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("user/user", model);
    }

    @GetMapping("list")
    public ModelAndView getAllUsers( ModelMap model) {
        return new ModelAndView("user/list", model.addAttribute("list", userService.getList()));
    }

    @GetMapping("id")
    public ModelAndView findById(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("user/userById", model);
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("user/userById", model);
        }
        Optional<User> optionalUser = userService.getById(id);
        if (!optionalUser.isPresent()) {
            return new ModelAndView("user/userById", model);
        }
        model.addAttribute("error", "SUCCESSFULLY");
        return new ModelAndView("user/userById", model.addAttribute("list", userService.findListById(id)));
    }

    @GetMapping("name")
    public ModelAndView findByUserName(String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("user/userByName", model);
        }
        model.addAttribute("error", "SUCCESSFULLY");
        model.addAttribute("list", userService.getByName(name.toUpperCase()));
        return new ModelAndView("user/userByName", model);
    }

//    @Secured({ "ROLE_ADMIN" })
    @GetMapping("delete")
    public ModelAndView delete(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("user/deleteUser", model);
        }
        if (!Validator.validId(id)) {
            model.addAttribute("error", "Wrong ID");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/deleteUser", model);
        }
        if (!userService.getById(id).isPresent()) {
            model.addAttribute("error", "User With ID = " + id + " Is Empty");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/deleteUser", model);
        }
        if (userService.getById(id).get().getName().equalsIgnoreCase("admin")) {
            model.addAttribute("error", "Sorry, You Cannot Delete The Administrator");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/deleteUser", model);
        }
        model.addAttribute("error2", "User Deleted");
        model.addAttribute("error", "SUCCESSFULLY");
        userService.deleteById(id);
        return new ModelAndView("redirect:/user", model);
    }

//    @Secured({ "ROLE_ADMIN" })
    @GetMapping("new")
    public ModelAndView addNew( User user,  ModelMap model) {
        return new ModelAndView("user/newUser", model.addAttribute("user", user));
    }

//    @Secured({ "ROLE_ADMIN" })
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public ModelAndView addNewPost( User user, ModelMap model) {
        if (user.getId() == null) {
            return new ModelAndView("user/newUser", model);
        }
        model.addAttribute("error2", "User Added");
        model.addAttribute("error", "SUCCESSFULLY");
        user.setName(user.getName().toUpperCase());
        userService.saveEntity(user);
        return new ModelAndView("user/user", model.addAttribute("user", user));
    }

//    @Secured({ "ROLE_ADMIN" })
    @GetMapping("update/**")
    public ModelAndView update( User user, ModelMap model) {
        return new ModelAndView("user/updateUser", model.addAttribute("user", user));
    }

//    @Secured({ "ROLE_ADMIN" })
    @RequestMapping(value = "update/**", method = RequestMethod.POST)
    public ModelAndView updatePost(  @NotNull User user, ModelMap model) {
        if (!Validator.validId(user.getId())) {
            model.addAttribute("error2", "Try Again");
            model.addAttribute("error", "Wrong ID");
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getName().equalsIgnoreCase("admin")) {
            model.addAttribute("error", "Sorry, You Cannot Update The Administrator");
            model.addAttribute("error2", "Try again");
            return new ModelAndView("user/updateUser", model);
        }
        model.addAttribute("error2", "User Updated");
        model.addAttribute("error", "SUCCESSFULLY");
        user.setName(user.getName().toUpperCase());
        userService.saveEntity(user);
        return new ModelAndView("user/user", model);
    }
}

//
//    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
//    public ModelAndView createNewUser(final @Valid @ModelAttribute Person user,
//                                      final BindingResult result,
//                                      final SessionStatus status,
//                                      final @RequestParam(value = "unencodedPassword", required = true) String password) {
//        ...
//        user.getRoles().add(new Role(user, Role.APPLICATION_ROLE.ROLE_USER));
//        userDao.createNewUser(user);
//        ...
//    }

//    in controller

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @PostMapping("/user")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User addUser(@RequestBody User user) {
//        List<User> userList = new ArrayList<>();
//        userList.add(user);
//        return user;
//    }
// разрешает всем @PreAuthorize("isAuthenticated()")
//   @Secured("ROLE_ADMIN")  право доступа

//    @PreAuthorize("#animal.name == authentication.name")
//    @PostMapping("/special")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User addAdmin(@RequestBody User user) {
//        List<User> userList = new ArrayList<>();
//        userList.add(user);
//        return user;
//    }


//2) ну и перeдавать в POST-запросе localhost:8080/login form-data, к примеру такие:
//username: user
//password: password

//    Можно сделать авторизацию на уровне методов, например, если пользователь приложения AppUser может редактировать только свой объект Thing, то аннотируем метод редактирования так:
//
//@PreAuthorize("authentication.principal.username.equals(#thing.appUser.username)")
//public Thing editThing(Thing thing) {
////...
//}
//(подразумевается, что Thing имеет ссылку на юзера)

//    1. Возможно не включили @EnableGlobalMethodSecurity(prePostEnabled = true) на главном классе.
//2. @PreAuthorize рекомендуется ставить на методы сервисов