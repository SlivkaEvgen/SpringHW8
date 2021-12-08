package org.goit.springhw8.controller;

import jakarta.validation.Valid;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserService;
import org.goit.springhw8.util.Validator;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user") //OK
    public ModelAndView entity(ModelMap model) {
        return new ModelAndView("user/user", model);
    }

    @GetMapping("list") //OK
    public ModelAndView getAllUsers(@NotNull ModelMap model) {
        return new ModelAndView("user/list", model.addAttribute("list", userService.getList()));
    }

    @GetMapping("id") //OK
    public ModelAndView findById(String id, ModelMap model) {
        if (id == null) {
            return new ModelAndView("user/userById", model);
        }
        if (id.isEmpty()){
            return new ModelAndView("user/userById", model.addAttribute("id",id).addAttribute("error", " User ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("user/userById", model.addAttribute("id",id).addAttribute("model", model).addAttribute("error", "Wrong User ID "+id).addAttribute("error2", "Please, Try Again"));
        }
        if (!userService.getById(id).isPresent()) {
            return new ModelAndView("user/userById", model.addAttribute("id",id).addAttribute("model", model).addAttribute("error", "Could Not Find By ID "+id).addAttribute("error2", "Please, Try Again"));
        }
        return new ModelAndView("user/userById", model.addAttribute("error2", "SUCCESSFULLY").addAttribute("list", userService.findListById(id)));
    }

    @GetMapping("name") // OK
    public ModelAndView findByUserName(@AuthenticationPrincipal String name, ModelMap model) {
        if (name == null) {
            return new ModelAndView("user/userByName", model);
        }
        if (name.isEmpty()) {
            return new ModelAndView("user/userByName", model.addAttribute("name",name).addAttribute("model", model).addAttribute("error", " User Name Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validName(name)){
            return new ModelAndView("user/userByName", model.addAttribute("name",name).addAttribute("model", model).addAttribute("error", " Wrong User Name ").addAttribute("error2", "Please, Try Again"));
        }
        if (userService.getByName(name).isEmpty()){
            return new ModelAndView("user/userByName", model.addAttribute("name",name).addAttribute("model", model).addAttribute("error", "Could Not Find By Name "+name).addAttribute("error2", "Please, Try Again"));
        }
        return new ModelAndView("user/userByName", model.addAttribute("error2", "SUCCESSFULLY").addAttribute("list", userService.getByName(name.toUpperCase())));
    }

//    @Secured({"ROLE_ADMIN"})
    @Secured({"ADMIN"})
    @GetMapping("delete") //OK  //добавить логику, если у мануфактурера есть товары
    public ModelAndView delete( String id,@AuthenticationPrincipal ModelMap model) {
        if (id == null) {
            return new ModelAndView("user/deleteUser", model);
        }
        if (id.isEmpty()){
            return new ModelAndView("user/deleteUser", model.addAttribute("error", " User ID Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (!Validator.validId(id)) {
            return new ModelAndView("user/deleteUser", model.addAttribute("id",id).addAttribute("error", "Wrong User ID").addAttribute("error2", "Please, Try Again"));
        }
        if (!userService.getById(id).isPresent()) {
            return new ModelAndView("user/deleteUser", model.addAttribute("id",id).addAttribute("error", "User With ID = " + id + " Is Empty").addAttribute("error2", "Please, Try Again"));
        }
        if (userService.getById(id).get().getName().equalsIgnoreCase("admin")) {
            return new ModelAndView("user/deleteUser", model.addAttribute("id",id).addAttribute("error", "Sorry, You Cannot Delete The Administrator").addAttribute("error2", "Please, Try Again"));
        }
        userService.deleteById(id);
        return new ModelAndView("redirect:/user", model.addAttribute("error", "User Deleted").addAttribute("error2", "SUCCESSFULLY"));
    }

    @Secured({ "ROLE_ADMIN" })
    @GetMapping("new/**") //OK
    public ModelAndView addNew(@AuthenticationPrincipal User user,
                               @RequestParam(value = "bCryptPasswordEncoder", required = true) String password,
                               @NotNull ModelMap model) {
        return new ModelAndView("user/newUser", model.addAttribute("user", user));
    }

    @Secured({ "ROLE_ADMIN" }) //OK
    @RequestMapping(value = "new/**", method = RequestMethod.POST)
    public ModelAndView addNewPost(@Valid @ModelAttribute User user, ModelMap model) {
        if (user.getId() == null) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getName()==null){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getPassword()==null){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getGender()==null){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getEmail()==null){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getLastName()==null){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getRoles()==null){
            return new ModelAndView("user/newUser", model);
        }

        if (user.getId().isEmpty()) {
            return new ModelAndView("user/newUser", model);
        }
        if (user.getName().isEmpty()){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getPassword().isEmpty()){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getGender().name().isEmpty()){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getEmail().isEmpty()){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getLastName().isEmpty()){
            return new ModelAndView("user/newUser", model);
        }
        if (user.getRoles().isEmpty()){
            return new ModelAndView("user/newUser", model);
        }

        if (!Validator.validId(user.getId())){
            return new ModelAndView("user/newUser", model);
        }
        if (!Validator.validName(user.getName())){
            return new ModelAndView("user/newUser", model);
        }
        if (!Validator.validName(user.getLastName())){
            return new ModelAndView("user/newUser", model);
        }
        if (!Validator.validEmail(user.getEmail())){
            return new ModelAndView("user/newUser", model);
        }
        if (!Validator.validGender(user.getGender().name())){
            return new ModelAndView("user/newUser", model);
        }

        user.setName(user.getName().toUpperCase());
        userService.saveEntity(user);
        return new ModelAndView("user/user", model.addAttribute("user", model.addAttribute("error", "User Added").addAttribute("error2", "SUCCESSFULLY")));
    }

    @Secured({ "ROLE_ADMIN" })
    @GetMapping("update/**") //OK
    public ModelAndView update(@AuthenticationPrincipal User user,
                               @NotNull ModelMap model) {
        return new ModelAndView("user/updateUser", model.addAttribute("user", user));
    }

    @Secured({ "ROLE_ADMIN" })
    @RequestMapping(value = "update/**", method = RequestMethod.POST) //OK
    public ModelAndView updatePost(@AuthenticationPrincipal User user,
                                   @RequestParam(value = "bCryptPasswordEncoder", required = true) String password,
                                   @NotNull ModelMap model) {
        if (user.getId() == null) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getName()==null){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getPassword()==null){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getGender()==null){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getEmail()==null){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getLastName()==null){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getRoles()==null){
            return new ModelAndView("user/updateUser", model);
        }

        if (user.getId().isEmpty()) {
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getName().isEmpty()){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getPassword().isEmpty()){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getGender().name().isEmpty()){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getEmail().isEmpty()){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getLastName().isEmpty()){
            return new ModelAndView("user/updateUser", model);
        }
        if (user.getRoles().isEmpty()){
            return new ModelAndView("user/updateUser", model);
        }

        if (!Validator.validId(user.getId())){
            return new ModelAndView("user/updateUser", model);
        }
        if (!Validator.validName(user.getName())){
            return new ModelAndView("user/updateUser", model);
        }
        if (!Validator.validName(user.getLastName())){
            return new ModelAndView("user/updateUser", model);
        }
        if (!Validator.validEmail(user.getEmail())){
            return new ModelAndView("user/updateUser", model);
        }
        if (!Validator.validGender(user.getGender().name())){
            return new ModelAndView("user/updateUser", model);
        }

        if (user.getName().equalsIgnoreCase("role_admin")) {
            return new ModelAndView("user/updateUser", model.addAttribute("error", "Sorry, You Cannot Update The Administrator").addAttribute("error2", "Please,Try again"));
        }

        user.setName(user.getName().toUpperCase());
        userService.saveEntity(user);
        return new ModelAndView("user/user", model.addAttribute("user",user).addAttribute("error", "User Updated").addAttribute("error2", "SUCCESSFULLY"));
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