package org.goit.springhw8.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.goit.springhw8.model.User;
import org.goit.springhw8.repository.RepositoryI;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDtoUserDetails implements UserDetailsService {

    private RepositoryI<User,String> repositoryI;

    public UserDtoUserDetails(RepositoryI<User,String> repositoryI){
        System.out.println("UserDtoUserDetails ");
        this.repositoryI=repositoryI;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(@NotNull String name) throws UsernameNotFoundException {
        System.out.println("UserDtoUserDetails loadUserByUsername name= "+name);

        List<User> userList = repositoryI.findByName(name.toUpperCase());
        if (userList == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return (UserDetails) userList.get(0);
    }

}
