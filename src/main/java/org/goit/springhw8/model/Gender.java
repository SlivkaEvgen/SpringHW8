package org.goit.springhw8.model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum Gender {

    SEX_MALE,
    SEX_FEMALE;

    @NotNull
    @Contract(pure = true)
    public  String getGender() {
        return name();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
