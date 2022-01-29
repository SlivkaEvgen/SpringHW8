package org.goit.springhw8.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.goit.springhw8.model.enums.Gender;
import org.goit.springhw8.model.enums.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.util.annotations.NameValid;
import org.goit.springhw8.util.annotations.PasswordMatches;
import org.goit.springhw8.util.annotations.ValidEmail;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * The type User dto.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NameValid
@RequiredArgsConstructor
@PasswordMatches
public class UserDto extends User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "name")
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(name = "password")
    private String password;

    private String matchingPassword;

    @ValidEmail
    @NotNull
    @NotEmpty
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @NotEmpty
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @NotEmpty
    @Transient
    @AssertTrue
    private boolean active;

    @NotNull
    @NotEmpty
    @Transient
    @ToString.Exclude
    private String passwordConfirm;

    @NotNull
    @NotEmpty
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

}