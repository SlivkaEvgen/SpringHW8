package org.goit.springhw8.controller.swagger;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.goit.springhw8.model.Gender;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = "api/user")
public class UserApi {

    private final UserDetailsServiceImpl userDetailsServiceImpl;


    public UserApi(UserDetailsServiceImpl userDetailsServiceImpl){
        this.userDetailsServiceImpl=userDetailsServiceImpl;
    }

    @Operation(summary = "Show All Users",description = " All Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation", content =
                    {@Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content =
                    {@Content(mediaType = "application/json")})}  )
    @GetMapping("list")
    @ResponseBody
    public List<User> getAllUsers(){
        return userDetailsServiceImpl.getAll();
    }

    @Operation(summary = "Find User by ID",description = "Show User by ID")
    @GetMapping("id")
    @ResponseBody
    public Optional<User> getUserById(@ApiParam(required = true,value = " Example : 1 ")String id){
        return userDetailsServiceImpl.getById(id);
    }

    @Operation(summary = "Find Users by Name",description = " Show Users by Name ")
    @GetMapping("name")
    @ResponseBody
    public List<User> getUserByName(@ApiParam(required = true,value = " Example : admin ")String name){
        return userDetailsServiceImpl.findByName(name);
    }

    @Operation(summary = "Find by Email",description = "Show User by Email")
    @GetMapping("email")
    @ResponseBody
    public List<User> getUserByEmail(@ApiParam(required = true,value = " Example :  admin@ua ")String email){
        return userDetailsServiceImpl.findByEmail(email);
    }

    @Operation(summary = "Delete User",description = "Delete User")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUserById(@ApiParam(required = true, value = " Example : 4 ") @PathVariable String id){
        userDetailsServiceImpl.deleteById(id);
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    @ResponseBody
    @Operation(summary = "New User",description = "Create the New User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400",
                    description = "User not found by id specified in the request",//Invalid ID supplied =404
                    content = @Content)})
    public void addNewUserGet(@PathVariable(value = "First Name / Login") @ApiParam(value = " Example : Bill ") String firstName,
                              @PathVariable(value = "Last Name") @ApiParam(value = " Example : Gates ") String lastName,
                              @PathVariable(value = "Gender") @ApiParam() Gender gender,
                              @PathVariable(value = "Email") @ApiParam(value = " Example : billGates@ua ") String email,
                              @PathVariable(value = "Password") @ApiParam(value = " Example : 123456Ab ")  String password){
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.ROLE_USER);
        User user = new User();
        user.setActive(true);
        user.setId(user.getId());
        user.setName(firstName);
        user.setLastName(lastName);
        user.setGender(Gender.valueOf(gender.name()));
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(roleSet);
         userDetailsServiceImpl.saveEntity(user);
    }

    @Operation(summary = "Update User ",description = "Update User")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public void updateUserGet(@ApiParam(required = true)@PathVariable String id, @ApiParam(required = true) @PathVariable String firstName, @ApiParam(required = true) @PathVariable String lastName,
                              @ApiParam(required = true) @PathVariable Gender gender, @ApiParam(required = true) @PathVariable String email, @ApiParam(required = true,value = " password ") @PathVariable String password){//@ApiParam(required = true, value = "User user") User user

        Optional<User> userById = getUserById(id);
        if (!userById.isPresent()){
            return;
        }
        User user = userById.get();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(Role.ROLE_USER);
//        User user = new User();
        user.setActive(true);
        user.setId(id);
        user.setName(firstName);
        user.setLastName(lastName);
        user.setGender(Gender.valueOf(gender.name()));
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(roleSet);
        userDetailsServiceImpl.saveEntity(user);
    }

//    @Example(value = ElementType.PACKAGE.TYPE)
//    public static ElementType getExample(@ExampleProperty(value = ElementType.TYPE) String name){
//
//    }

//
//    public static ElementType values() {
//        for (ElementType c : ElementType.values()) {
////            System.out.println(c);
//            return c;
//        }
//        return null;
//    }
}
