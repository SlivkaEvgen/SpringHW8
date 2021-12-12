package org.goit.springhw8.model;

import jakarta.validation.constraints.NotNull;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

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

//    @Override
//    public String toString() {
//        return super.toString();
//    }
//
//    public static List<Role> getAll() {
//        return Arrays.asList(Role.ROLE_USER, ROLE_ADMIN);
//    }

}
