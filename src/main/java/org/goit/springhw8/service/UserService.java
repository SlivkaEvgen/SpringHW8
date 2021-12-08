package org.goit.springhw8.service;

import jakarta.validation.constraints.NotNull;
import org.goit.springhw8.model.User;
import org.goit.springhw8.repository.UserRepository;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserService extends ServiceI<User, String> {

    private final UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(@AuthenticationPrincipal UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) { //AuthenticationPrincipal
        super(userRepository);
        this.userRepository=userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @PreAuthorize("hasRole('USER')")
    @PostFilter("hasPermission(filterObject, 'read') or hasPermission(filterObject, 'ADMIN')")
    public List<User> getAll() {
        System.out.println("UserService getAll");
        return userRepository.findAll();
    }

    @Override
    public List<User> findListById(String id) {
        System.out.println("UserService findListById " + id);
        return super.findListById(id);
    }

    @Override
    public List<User> getByName(@NotNull String name) {
        System.out.println("UserService getByName " + name);
        return super.getByName(name);
    }
}
