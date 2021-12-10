package org.goit.springhw8.model;

import jakarta.validation.constraints.NotNull;
import org.jetbrains.annotations.Contract;

import java.util.Arrays;
import java.util.List;

@NotNull
public enum Gender {

    MALE,
    FEMALE;

    public  String getGender() {
        return name();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public List<Gender> getAll(){
        return Arrays.asList(Gender.MALE, Gender.FEMALE);
    }
}
