package org.goit.springhw8.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

@Validated
@Component
public class Validator {


    public static boolean validString(String hasLetters) {
        return hasLetters != null && !hasLetters.matches("\\d+");
    }

    private static boolean empty(String id) {
        return id != null && !id.isEmpty();
    }

    public static boolean validId(String id) {
        return empty(id) &&
                validNumber(id) &&
                id.length() <= 20 &&
                Long.parseLong(id) != 0;
    }

    public static boolean validName(String name) {
        return name != null &&
                !name.isEmpty() &&
                !name.equalsIgnoreCase("null") &&
                name.length() <= 12 &&
                !Validator.validNumber(name) &&
                validString(name);
    }

    public static boolean validGender(@ModelAttribute("gender") String gender) {
        return gender != null && (gender.equalsIgnoreCase("Male")
                | gender.equalsIgnoreCase("Female"));
    }

    public static boolean validEmail(String email) {
        return email != null && email.matches("/^[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}$/i");
    }

    public static boolean validNumber(String hasNumbers) {
        return !validString(hasNumbers) || hasNumbers.matches("\\d+");
    }

    public static boolean isValidNumbers(String isNumber){
        return isNumber != null &&
                isNumber.matches("/^\\d{1,}$/");
    }

    public static boolean isValidPrice(String price){
        return isValidNumbers(price) && price.matches("/(\\[0-9,]+(\\.[0-9]{2})?)/");
    }
}
