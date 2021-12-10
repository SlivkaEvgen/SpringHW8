package org.goit.springhw8.model;

import jakarta.validation.constraints.NotNull;

import javax.annotation.security.RolesAllowed;

@NotNull
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
public enum Role {

    ROLE_ADMIN,
    ROLE_USER

}
