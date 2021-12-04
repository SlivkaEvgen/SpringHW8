package org.goit.springhw8.model;

public enum Gender {

    SEX_MALE,
    SEX_FEMALE;

    public  String getGender() {
        return name();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
