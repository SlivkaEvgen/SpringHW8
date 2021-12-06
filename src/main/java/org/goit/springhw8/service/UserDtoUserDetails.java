//package org.goit.springhw8.service;
//
//import org.goit.springhw8.model.User;
//import org.goit.springhw8.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
////@RequestMapping("login")
//public class UserDtoUserDetails implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public UserDtoUserDetails(UserRepository userRepository) {
//        System.out.println("UserDtoUserDetails ");
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("UserDtoUserDetails loadUserByUsername name= " + username);
//        if (username == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        if (username.isEmpty()) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        List<User> userList = userRepository.findByName(username);
//        if (userList.isEmpty()) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return (UserDetails) userList.get(0);
//    }
//
//}
