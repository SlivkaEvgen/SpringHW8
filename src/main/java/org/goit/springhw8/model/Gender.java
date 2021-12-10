package org.goit.springhw8.model;

import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.List;

public enum Gender {

    MALE,
    FEMALE;

    @Override
    public String toString() {
        return super.toString();
    }

    @Contract(pure = true)
    public static List<Gender> getAll() {
        return Arrays.asList(Gender.MALE, Gender.FEMALE);
    }
}
