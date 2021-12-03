package org.goit.springhw8.service;

import org.goit.springhw8.model.User;
import org.goit.springhw8.repository.RepositoryI;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends ServiceI<User, Long> implements UserDetails {

    private final RepositoryI<User, Long> userRepository;

    public UserService(RepositoryI<User, Long> userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(Long.parseLong(String.valueOf(id)));
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void delete(Long id) {
        if (userRepository.findById(Long.parseLong(String.valueOf(id))).isPresent()) {
            userRepository.deleteById(Long.parseLong(String.valueOf(id)));
        }
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return new User().getPassword();
    }

    @Override
    public String getUsername() {
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

