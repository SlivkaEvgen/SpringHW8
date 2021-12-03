package org.goit.springhw8.service;

import org.goit.springhw8.model.User;
import org.goit.springhw8.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        List<User> userList = findUserByName(name.toUpperCase());
        if (userList == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return userList.get(0);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(String id) {
        return userRepository.findById(Long.parseLong(id));
    }

    public List<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void deleteUser(String id) {
        if (userRepository.findById(Long.parseLong(id)).isPresent()) {
            userRepository.deleteById(Long.parseLong(id));
        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}

