package org.goit.springhw8.service;

import jakarta.validation.constraints.NotNull;
import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;
import org.goit.springhw8.repository.UserRepository;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserService extends ServiceI<User, String> implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) { //AuthenticationPrincipal
        super(userRepository);
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostFilter("hasPermission(filterObject, 'read') or hasPermission(filterObject, 'USER')")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findListById(String id) {
        return super.findListById(id);
    }

    public Optional<User> findByUserId(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getByName(@AuthenticationPrincipal @NotNull String name) {
        return super.getByName(name);
    }

    @Override
    public User registerNewUserAccount(@org.jetbrains.annotations.NotNull UserDto userDto) {
        return userRepository.save(userDto);
    }

//    private boolean emailExist(String email) {
//        return userRepository.findByEmail(email) != null;
//    }

//    private boolean emailExists(String email) {
//        return userRepository.findByEmail(email) != null;
//    }
}