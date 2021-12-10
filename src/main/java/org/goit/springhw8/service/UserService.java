package org.goit.springhw8.service;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.goit.springhw8.model.Gender;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;
import org.goit.springhw8.repository.UserRepository;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Logger
@Service
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserService extends ServiceI<User, String> implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { //AuthenticationPrincipal
        super(userRepository);
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findListById(String id) {
        return super.findListById(id);
    }

    @Override
    public Optional<User> getById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return super.findByName(name.toUpperCase());
    }

    @Override
    public User registerNewUserAccount(UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public List<Gender> getGenderList() {
        return Arrays.asList(Gender.FEMALE,Gender.MALE);
    }

    public List<Role> getRoles(){
        return Arrays.asList(Role.values());
    }
}