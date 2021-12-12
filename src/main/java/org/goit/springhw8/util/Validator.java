package org.goit.springhw8.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * The type Validator.
 */
@Validated
@Component
public class Validator {

    /**
     * Valid string boolean.
     *
     * @param hasLetters the has letters
     * @return the boolean
     */
    public static boolean validString(String hasLetters) {
        return hasLetters != null && !hasLetters.matches("\\d+");
    }

    private static boolean empty(String id) {
        return id != null && !id.isEmpty();
    }

    /**
     * Valid id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean validId(@ModelAttribute("id") String id) {
        return empty(id) &&
                validNumber(id) &&
                Long.parseLong(id) != 0;
    }

    /**
     * Valid name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public static boolean validName(@ModelAttribute("name") String name) {
        return name != null &&
                !name.isEmpty() &&
                !name.equalsIgnoreCase("null") &&
                name.length() <= 12 &&
                !Validator.validNumber(name) &&
                validString(name);
    }

    /**
     * Valid gender boolean.
     *
     * @param gender the gender
     * @return the boolean
     */
    public static boolean validGender(@ModelAttribute("gender") String gender) {
        return gender != null && (gender.equalsIgnoreCase("MALE")
                | gender.equalsIgnoreCase("FEMALE"));
    }

    /**
     * Valid email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public static boolean validEmail(@ModelAttribute("email") String email) {
        return email != null && email.matches("/^[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}$/i");
    }

    /**
     * Valid number boolean.
     *
     * @param hasNumbers the has numbers
     * @return the boolean
     */
    public static boolean validNumber(String hasNumbers) {
        return !validString(hasNumbers) || hasNumbers.matches("\\d+");
    }

    /**
     * Is valid numbers boolean.
     *
     * @param isNumber the is number
     * @return the boolean
     */
    public static boolean isValidNumbers(String isNumber){
        return isNumber != null &&
                isNumber.matches("/^\\d{1,}$/");
    }

    /**
     * Is valid price boolean.
     *
     * @param price the price
     * @return the boolean
     */
    public static boolean isValidPrice(@ModelAttribute("price") String price){
        return isValidNumbers(price) && price.matches("/(\\[0-9,]+(\\.[0-9]{2})?)/");
    }
}
