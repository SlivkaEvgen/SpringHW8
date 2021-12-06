package org.goit.springhw8.model;

import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseModel<String>, UserDetails {

    private static final long serialVersionUID = -558_820_640_269_434_517L;

    @Size(min = 1, max = 50, message = "min = 1, max = 50")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    @Column(name = "name")
    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private String name;

    @Column(name = "last_name")
    @Size(min = 2, max = 25, message = "min = 2, max = 25")
    private String lastName;

    @Column(name = "gender", insertable = false)
    @Enumerated(EnumType.STRING)
    @Size(min = 4, max = 10, message = "min = 4, max = 10")
    private Gender gender;

    @Column(name = "email")
    @Size(min = 6, max = 35, message = "min = 6, max = 35")
    private String email;

    @Column(name = "password")
    @Size(min = 6, max = 100, message = "min = 6, max = 100")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Transient
    @ToString.Exclude
    private boolean active;

    @Transient
    @ToString.Exclude
    private String passwordConfirm;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getName();
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
