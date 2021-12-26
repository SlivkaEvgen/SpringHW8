package org.goit.springhw8.controller.swagger;

import io.swagger.annotations.Api;
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

@Api
@Controller
@RequestMapping(value = "api/user")
public class UserApiController { //@ApiParam(required = true,value = "User user")

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public UserApiController(UserDetailsServiceImpl userDetailsServiceImpl){
        this.userDetailsServiceImpl=userDetailsServiceImpl;
    }

    @Operation(summary = "Users list",description = "User list controller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {@Content(mediaType = "application/json")})}  )
    @GetMapping("list")
    @ResponseBody
    public List<User> getAllUsers(){
        return userDetailsServiceImpl.getAll();
    }

    @Operation(summary = "User by ID",description = "User controller")
    @GetMapping("id")
    @ResponseBody
    public Optional<User> getUserById(@ApiParam(required = true,value = "User ID")String id){
        return userDetailsServiceImpl.getById(id);
    }

    @Operation(summary = "Users list by Name",description = "Name in ignore or upper case")
    @GetMapping("name")
    @ResponseBody
    public List<User> getUserByName(@ApiParam(required = true,value = "User First Name")String name){
        return userDetailsServiceImpl.findByName(name);
    }

    @Operation(summary = "User by Email",description = "Case sensitive email")
    @GetMapping("email")
    @ResponseBody
    public List<User> getUserByEmail(@ApiParam(required = true,value = "ex:  admin@ua ")String email){
        return userDetailsServiceImpl.findByEmail(email);
    }

    @Operation(summary = "Delete User by ID",description = " User Delete controller")
    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUserById(@ApiParam(required = true, value = "User ID") @PathVariable String id){
        userDetailsServiceImpl.deleteById(id);
    }


    @Operation(summary = "Add new User ",description = " New User controller")
    @RequestMapping(value = "new", method = RequestMethod.POST)
    @ResponseBody
    public void addNewUserGet( String firstName, String lastName, Gender gender, String email, String password){
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


    @Operation(summary = "Update User ",description = " Update User controller")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public void updateUserGet(@ApiParam(required = true, value = "User user") User user){
        userDetailsServiceImpl.saveEntity(user);
    }
}
