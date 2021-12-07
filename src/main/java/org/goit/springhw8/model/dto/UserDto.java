package org.goit.springhw8.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.goit.springhw8.model.Gender;
import org.goit.springhw8.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Transient;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends User implements UserDetails {

    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    private String id;

    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private String name;

    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private String lastName;

    @Size(min = 4, max = 10, message = "min = 4, max = 10")
    private Gender gender;

    @Size(min = 6, max = 35, message = "min = 6, max = 35")
    private String email;

    @Size(min = 6, max = 100, message = "min = 6, max = 100")
    private String password;

    private Set<RoleDto> roleDtoSet;

    public void setRoleDtoSet(Set<RoleDto> roleDtoSet) {
        this.roleDtoSet = roleDtoSet;
    }

    @Transient
    @ToString.Exclude
    private String passwordConfirm;

    @Transient
    @ToString.Exclude
    private boolean active;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleDtoSet;
    }

    @Override
    public String getUsername() {
        return getName().toUpperCase();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
