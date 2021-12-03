package org.goit.springhw8.service;

import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.User;
import org.goit.springhw8.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDtoUserDetails implements UserDetailsService {

    private  UserRepository userRepository;

    public UserDtoUserDetails(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        List<User> userList = userRepository.findByName(name.toUpperCase());
        if (userList == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return (UserDetails) userList.get(0);
    }

}
