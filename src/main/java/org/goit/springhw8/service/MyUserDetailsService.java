package org.goit.springhw8.service;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//@Logger
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        System.out.println("username " + userRepository.findByName(username.toUpperCase()));
        User user = userRepository.findByName(username.toUpperCase()).get();
//        System.out.println(user);
//        if (!user.isPresent()) {
//            throw new UsernameNotFoundException("No user found with username: " + username);
//        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        user.setActive(true);
        return new org.springframework.security.core.userdetails.User(
                user.getName().toUpperCase(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user.getRoles()));
    }

    @NotNull
    private static List<GrantedAuthority> getAuthorities(@NotNull Set<Role> roles) {
        System.out.println("getAuthorities" + roles);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        }
        return authorities;
    }
}
