package org.goit.springhw8.service;

import org.goit.springhw8.model.Gender;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;
import org.goit.springhw8.repository.UserRepository;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type My user details service.
 */
@Service
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyUserDetailsService extends ServiceI<User, String> implements UserDetailsService, IUserService {

    private final UserRepository userRepository;

    /**
     * Instantiates a new My user details service.
     *
     * @param userRepository the user repository
     */
    public MyUserDetailsService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@ModelAttribute("username") String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username, "USER NOT FOUND");
        User user = userRepository.findByName(username.toUpperCase()).get(0);
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

    private static List<GrantedAuthority> getAuthorities(@ModelAttribute("role") Set<Role> roles) {
        return roles == null || roles.isEmpty() ? null : roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    @Override
    public User registerNewUserAccount(@ModelAttribute("userDto") UserDto userDto) {
        return userRepository.save(userDto);
    }

    /**
     * Gets gender list.
     *
     * @return the gender list
     */
    public List<Gender> getGenderList() {
        return Arrays.asList(Gender.FEMALE, Gender.MALE);
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }
}
//    @Override
//    public List<User> getAll() {
//        return super.getAll();
//    }
//
//    @Override
//    public List<User> findListById(String id) {
//        return super.findListById(id);
//    }
//
//    @Override
//    public Optional<User> getById(String id) {
//        return super.getById(id);
//    }
//
//    @Override
//    public Optional<User> findByName(String name) {
//        if (name == null) {
//            return Optional.empty();
//        }
//        return super.findByName(name.toUpperCase());
//    }
//
////    public User registerNewUserAccount(UserDto userDto) {
////        return userRepository.save(userDto);
////    }
//
//    @Override
//    public void deleteById(String id) {
//        super.deleteById(id);
//    }
//
//    public void saveUser(User user) {
//        super.saveEntity(user);
//    }
//