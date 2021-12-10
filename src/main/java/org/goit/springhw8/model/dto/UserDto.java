package org.goit.springhw8.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.Gender;
import org.goit.springhw8.model.Role;
import org.goit.springhw8.model.User;
import org.goit.springhw8.util.PasswordMatches;
import org.goit.springhw8.util.ValidEmail;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@PasswordMatches
public class UserDto extends User {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private Gender gender;

    @NotNull
    @NotEmpty
    private Set<Role> roles;

    @NotNull
    @NotEmpty
    private boolean active;

    @NotNull
    @NotEmpty
    private String passwordConfirm;

}
