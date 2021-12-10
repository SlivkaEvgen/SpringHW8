package org.goit.springhw8.model;

import jakarta.validation.constraints.NotNull;

import javax.annotation.security.RolesAllowed;

/**
 * The enum Role.
 */
@NotNull
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
public enum Role {

    /**
     * Role admin role.
     */
    ROLE_ADMIN,
    /**
     * Role user role.
     */
    ROLE_USER

}
