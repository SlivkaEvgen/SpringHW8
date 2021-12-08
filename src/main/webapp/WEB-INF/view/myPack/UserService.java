//package org.goit.springhw8.service;
//
//import jakarta.validation.Valid;
//import lombok.extern.log4j.Log4j;
//import org.goit.springhw8.model.Role;
//import org.goit.springhw8.model.User;
//import org.goit.springhw8.model.dto.MappingUtils;
//import org.goit.springhw8.model.dto.RoleDto;
//import org.goit.springhw8.model.dto.UserDto;
//import org.goit.springhw8.repository.UserRepository;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Log4j
//@Service
//public class UserService extends ServiceI<User, String>  {
//
//    private final UserRepository userRepository;
//
////    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
////    private final MappingUtils mappingUtils;
//
//    public UserService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder,MappingUtils mappingUtils) {
//        super(userRepository);
//        this.userRepository=userRepository;
////        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
//        this.mappingUtils=mappingUtils;
//    }
//
//    public List<UserDto> getDtoByName(String name) {
//        List<UserDto> users = new ArrayList<>();
//        List<User> userList = userRepository.findByName(name.toUpperCase());
//
//        UserDto userDto = mappingUtils.mapToUserDto(userList.get(0));
////        User user = mappingUtils.mapToUserEntity((UserDto) userList.get(0));
//        users.add(userDto);
//        return users;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(@AuthenticationPrincipal @NotNull String username) throws UsernameNotFoundException {
//        System.out.println(" UserService loadUserByUsername "+username);
//        UserDto user = getDtoByName(username.toUpperCase()).get(0);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return  user;
//    }
//
//    public boolean saveUser(@Valid User user) {
////        User user1 = new User(user);
//        System.out.println(" UserService saveUser "+user);
//        if (user==null){
//            return false;
//        }
//        if (user.getName()==null){
//            return false;
//        }
//        if (user.getPassword()==null){
//            return false;
//        }
//
//        user.setRoles(Collections.singleton(new Role("2","ROLE_USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return true;
//    }
//
//}
//
