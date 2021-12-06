package org.goit.springhw8.service;

import org.goit.springhw8.model.User;
import org.goit.springhw8.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceI<User, String> {  //  implements UserDetails

    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
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
}

