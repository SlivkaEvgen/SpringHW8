package org.goit.springhw8.model;

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
}
