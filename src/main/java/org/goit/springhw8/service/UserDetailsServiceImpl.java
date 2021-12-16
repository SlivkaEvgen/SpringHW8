package org.goit.springhw8.service;

import jdk.nashorn.internal.runtime.logging.Logger;
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

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type User details service.
 */
@Logger
@Service
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserDetailsServiceImpl extends ServiceI<User, String> implements UserDetailsService, IUserService {

    private final UserRepository userRepository;

    /**
     * Instantiates a new User details service.
     *
     * @param userRepository the user repository
     */
    public UserDetailsServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    /**
     * load user by username
     *
     * @param username username
     * @return {@link UserDetails}
     * @see UserDetails
     * @throws UsernameNotFoundException org.springframework.security.core.userdetails. username not found exception
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> byName = userRepository.findByName(username.toUpperCase());
        User user = byName.get(0);
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

    /**
     * get authorities
     *
     * @param roles roles
     * @return {@link List}
     * @see List
     * @see GrantedAuthority
     */
    private static List<GrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles == null || roles.isEmpty() ? null : roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }

    /**
     * register new user account
     *
     * @param userDto userDto
     * @return {@link User}
     * @see User
     */
    @Override
    public User registerNewUserAccount(UserDto userDto) {
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
     * Gets role list.
     *
     * @return the role list
     */
    public List<Role> getRoleList() {
        return Arrays.asList(Role.values());
    }
}
