package org.goit.springhw8.service;

import org.goit.springhw8.model.User;
import org.goit.springhw8.repository.RepositoryI;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("login")
public class UserService extends ServiceI<User, String> implements UserDetails {

    private final RepositoryI<User, String> userRepository;

    public UserService(RepositoryI<User, String> userRepository) {
        super(userRepository);
        System.out.println(";3m3;mk");

        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void delete(String id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(" getAuthorities ");
        return null;
    }

    @Override
    public String getPassword() {
        System.out.println("getUsername");
        return new User().getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("getUsername");
        return new User().getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

