package org.goit.springhw8.service;

import jakarta.validation.constraints.NotNull;
import org.goit.springhw8.model.Gender;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;
import org.goit.springhw8.repository.RoleRepository;
import org.goit.springhw8.repository.UserRepository;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserService extends ServiceI<User, String> implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,RoleRepository roleRepository) { //AuthenticationPrincipal
        super(userRepository);
        this.userRepository = userRepository;
        this.roleRepository=roleRepository;
    }

    //    @PreAuthorize("hasRole('ROLE_USER')")
//    @PostFilter("hasPermission(filterObject, 'read') or hasPermission(filterObject, 'USER')")
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
    public List<User> getByName(@NotNull String name) {
        return super.getByName(name);
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
        return  roleRepository.findAll();
    }
}