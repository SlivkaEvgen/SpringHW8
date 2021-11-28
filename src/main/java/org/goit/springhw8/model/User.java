package org.goit.springhw8.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseModel<Long> ,UserDetails{

    private static final long serialVersionUID = -558_820_640_269_434_517L;

    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 15)
    private Long id;

    @Length(min = 2)
    @Column(name = "name", length = 15)
    private String name;

    @Column(name = "last_name", length = 15)
    private String lastName;

    @Column(name = "gender", length = 15, insertable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "role_id")
    private Role role;

    @Transient
    private boolean active;

    @Transient
    private String passwordConfirm;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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

    public User(){

    }
}
