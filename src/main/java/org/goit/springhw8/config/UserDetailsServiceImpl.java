//package org.goit.springhw8.config;
//
//import org.goit.springhw8.model.Role;
//import org.goit.springhw8.model.User;
//import org.goit.springhw8.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        // с помощью нашего сервиса UserService получаем User
//        System.out.println(email);
//        User user = userService.getByName("colibri").get(0);
//        // указываем роли для этого пользователя
//        Set<GrantedAuthority> roles = new HashSet();
//        roles.add(new SimpleGrantedAuthority(Role.class.getSimpleName()));
//
//        // на основании полученных данных формируем объект UserDetails
//        // который позволит проверить введенный пользователем логин и пароль
//        // и уже потом аутентифицировать пользователя
//        UserDetails userDetails =
//                new org.springframework.security.core.userdetails.User(user.getName(),
//                        user.getPassword(),
//                        roles);
//
//        return userDetails;
//    }
//
//    @Bean
//    public UserDetailsService getUserDetailsService(){
//        return new UserDetailsServiceImpl();
//    }
//
//}
