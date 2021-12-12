package org.goit.springhw8.model;

import jakarta.validation.constraints.AssertTrue;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * The type User.
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseModel<String> {

    private static final long serialVersionUID = -558_820_640_269_434_517L;

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Note> notes;

    @Transient
    @AssertTrue
    private boolean active;

    @Transient
    @ToString.Exclude
    private String passwordConfirm;

}
