package org.goit.springhw8.model;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.goit.springhw8.util.annotations.NameValid;
import org.goit.springhw8.util.annotations.PasswordMatches;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * The type User.
 */
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@NameValid
@PasswordMatches
@ApiModel
@Table(name = "users")
public class User implements BaseModel<String> {

    private static final long serialVersionUID = -558_820_640_269_434_517L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
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

    @Transient
    @AssertTrue
    private boolean active;

    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

}
