package org.goit.springhw8.service;

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

@Service
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserService extends ServiceI<User, String> implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public List<User> findListById(String id) {
        return super.findListById(id);
    }

    @Override
    public Optional<User> getById(String id) {
        return super.getById(id);
    }

    @Override
    public Optional<User> findByName(String name) {
        if (name == null) {
            return Optional.empty();
        }
        return super.findByName(name.toUpperCase());
    }

    @Override
    public User registerNewUserAccount(UserDto userDto) {
        System.out.println("registerNewUserAccount = " + userDto);
        return userRepository.save(userDto);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    public void saveUser(User user) {
        super.saveEntity(user);
    }

    public List<Gender> getGenderList() {
        return Arrays.asList(Gender.FEMALE, Gender.MALE);
    }

    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }
}