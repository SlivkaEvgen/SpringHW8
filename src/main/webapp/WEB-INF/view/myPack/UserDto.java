//package org.goit.springhw8.model.dto;
//
//import jakarta.validation.constraints.AssertTrue;
//import jakarta.validation.constraints.Size;
//import lombok.*;
//import org.goit.springhw8.model.Gender;
//import org.goit.springhw8.model.Role;
//import org.goit.springhw8.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.Transient;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//
//@EqualsAndHashCode(callSuper = true)
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class UserDto extends User implements UserDetails {
//
//    @Size(min = 1, max = 50, message = "min = 1, max = 50")
//    private String id;
//
//    @Size(min = 2, max = 25, message = "min = 2, max = 25")
//    private String name;
//
//    @Size(min = 2, max = 25, message = "min = 2, max = 25")
//    private String lastName;
//
//    @Size(min = 4, max = 10, message = "min = 4, max = 10")
//    private Gender gender;
//
//    @Size(min = 6, max = 35, message = "min = 6, max = 35")
//    private String email;
//
//    @Size(min = 6, max = 100, message = "min = 6, max = 100")
//    private String password;
//
//    private Set<Role> roleSet;
//
//    @Override
//    public Set<Role> getRoles() {
//        return super.getRoles();
//    }
//
//    public void setRole(Set<Role> roleSet){
//        this.roleSet=roleSet;
//    }
//
//    @Transient
//    private String passwordConfirm;
//
//    @Transient
//    @AssertTrue
//    private boolean active;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//       return super.getRoles();
//    }
//
//    @Override
//    public String getUsername() {
//       return name;
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
//
//}
