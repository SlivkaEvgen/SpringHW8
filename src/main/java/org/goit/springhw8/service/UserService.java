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
        System.out.println("UserService getAll");
        return userRepository.findAll();
    }

    @Override
    public List<User> findListById(String id) {
        System.out.println("UserService findListById " + id);
        return super.findListById(id);
    }

    public Optional<User> findByUserId(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getByName(@AuthenticationPrincipal @NotNull String name) {
        System.out.println("UserService getByName " + name);
        return super.getByName(name);
    }

    @Override
    public User registerNewUserAccount(@org.jetbrains.annotations.NotNull UserDto userDto) {
        if (emailExist(userDto.getEmail())) {
            System.out.println("registerNewUserAccount");
        }
        return userRepository.save(userDto);
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}

//    @Override
//    public User registerNewUserAccount(UserDto userDto) {
//        if (emailExists(userDto.getEmail())) {
//            System.out.println("registerNewUserAccount ");
////            throw new UserAlreadyExistException("There is an account with that email address: "
////                    + userDto.getEmail());
//        }
//
//        User user = new User();
//        user.setName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        user.setPassword(userDto.getPassword());
//        user.setEmail(userDto.getEmail());
//        user.setRoles(Collections.singleton(new Role("2", "ROLE_USER")));
//
//        return userRepository.save(user);
//    }