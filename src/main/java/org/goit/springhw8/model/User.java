package org.goit.springhw8.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseModel<String> {

    private static final long serialVersionUID = -558_820_640_269_434_517L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender", insertable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Transient
    @AssertTrue
    private boolean active;

    @Transient
    @ToString.Exclude
    private String passwordConfirm;

    public User(String firstName, String lastName, String gender, String email, String password) {
        this.name=firstName;
        this.lastName=lastName;
        this.gender= Gender.valueOf(gender);
        this.email=email;
        this.password=password;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> permissions = new ArrayList<GrantedAuthority>();
        for (GrantedAuthority role: roles) {
            permissions.addAll(roles);
        }
        return permissions;
    }
}
