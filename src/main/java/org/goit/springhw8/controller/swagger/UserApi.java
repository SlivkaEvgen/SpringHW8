package org.goit.springhw8.controller.swagger;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.goit.springhw8.model.User;
import org.goit.springhw8.model.enums.Gender;
import org.goit.springhw8.model.enums.Role;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(value = "api/user")
public class UserApi {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public UserApi(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Operation(summary = "Show All Users", description = " All Users")
    @GetMapping("list")
    @ResponseBody
    public List<User> getAllUsers() {
        return userDetailsServiceImpl.getAll();
    }

    @Operation(summary = "Find User by ID", description = "Show User by ID")
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<User> getUserById(@PathVariable @ApiParam(required = true, value = " Example : 1 ") String id) {
        return userDetailsServiceImpl.getById(id);
    }

    @Operation(summary = "Find Users by Name", description = " Show Users by Name ")
    @GetMapping("/name/{name}")
    @ResponseBody
    public List<User> getUserByName(@PathVariable @ApiParam(required = true, value = " Example : user ") String name) {
        return userDetailsServiceImpl.findByName(name);
    }

    @Operation(summary = "Find by Email", description = "Show User by Email")
    @GetMapping("/email/{email}")
    @ResponseBody
    public Optional<User> getUserByEmail(@PathVariable @ApiParam(required = true, value = " Example :  user@ua ") String email) {
        return userDetailsServiceImpl.findByEmail(email);
    }

    @Operation(summary = "Delete User", description = "Delete User")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUserById(@ApiParam(required = true, value = " Example : 4 ") @PathVariable String id) {
        userDetailsServiceImpl.deleteById(id);
    }

    @Operation(summary = "New User", description = "Create the New User")
    @RequestMapping(value = "/new/{firstName}&{email}&{gender}&{lastName}&{password}", method = RequestMethod.POST)
    @ResponseBody
    public User addNewUserGet(@PathVariable @ApiParam(value = " Example : Bill ") String firstName,
                              @PathVariable @ApiParam(value = " Example : Gates ") String lastName,
                              @PathVariable @ApiParam(value = " Example : MALE ") Gender gender,
                              @PathVariable @ApiParam(value = " Example : billGates@ua ") String email,
                              @PathVariable @ApiParam(value = " Example : 123456abc ") String password) {
        User user = setIntoUser(new User(),
                firstName,
                lastName,
                email,
                gender,
                password);
        userDetailsServiceImpl.saveEntity(user);
        return user;
    }

    @Operation(summary = "Update User ", description = "Update User By ID")
    @RequestMapping(value = "/update/{id}&{firstName}&{lastName}&{gender}&{email}&{password}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUserGet(@PathVariable @ApiParam(value = " Example : 22 ") String id,
                              @PathVariable @ApiParam(value = " Example : Bill ") String firstName,
                              @PathVariable @ApiParam(value = " Example : Gates ") String lastName,
                              @PathVariable @ApiParam(value = " Example : MALE ") Gender gender,
                              @PathVariable @ApiParam(value = " Example : billGates@ua ") String email,
                              @PathVariable @ApiParam(value = " Example : 123456abc ") String password) {

        Optional<User> userById = getUserById(id);
        if (userById.isPresent()) {
            if (!userById.get().getEmail().equals(email)) {
                if (getUserByEmail(email).isPresent()) {
                    User user = getUserByEmail(email).get();
                    if (!user.getId().equals(id)) {
                        return null;
                    }
                }
            }
            User user = setIntoUser(userById.get(),
                    firstName,
                    lastName,
                    email,
                    gender,
                    password);
            userDetailsServiceImpl.saveEntity(user);
            return user;
        } else {
            return null;
        }
    }

    private User setIntoUser(User user, String firstName, String lastName, String email, Gender gender, String password) {
        if (firstName == null) {
            return null;
        }
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.ROLE_USER);
        user.setActive(true);
        user.setName(firstName.toUpperCase());
        user.setLastName(lastName.toUpperCase());
        user.setGender(gender);
        user.setEmail(email);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setRoles(roleSet);
        return user;
    }
}