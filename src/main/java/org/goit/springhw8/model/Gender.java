package org.goit.springhw8.model;

import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.List;

@NotNull
public enum Gender {

    MALE,
    FEMALE;

    @Override
    public String toString() {
        return super.toString();
    }

    @org.jetbrains.annotations.NotNull
    @Contract(pure = true)
    public List<Gender> getAll() {
        return Arrays.asList(Gender.MALE, Gender.FEMALE);
    }
}
