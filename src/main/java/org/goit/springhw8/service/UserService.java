package org.goit.springhw8.service;

import org.goit.springhw8.model.User;
import org.goit.springhw8.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceI<User,String>{

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}

    //implements UserDetails {

//    public UserService(RepositoryI<User, String> repositoryI) {
//        super(repositoryI);
//    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        System.out.println(" getAuthorities ");
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        System.out.println("getUsername");
//        return new User().getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        System.out.println("getUsername");
//        return new User().getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}

