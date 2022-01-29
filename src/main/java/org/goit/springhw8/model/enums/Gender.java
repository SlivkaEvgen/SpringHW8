package org.goit.springhw8.model.enums;

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

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public  String getGender() {
        return name();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
