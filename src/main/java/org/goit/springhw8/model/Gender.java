package org.goit.springhw8.model;

import java.util.Arrays;
import java.util.List;

/**
 * The enum Gender.
 */
public enum Gender {

    /**
     * Male gender.
     */
    MALE,
    /**
     * Female gender.
     */
    FEMALE;

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public static List<Gender> getAll() {
        return Arrays.asList(Gender.MALE, Gender.FEMALE);
    }
}
