package org.goit.springhw8.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

@Validated
@Component
public class Validator {

    public static boolean validNumber(String hasNumbers) {
        if (!validString(hasNumbers)) {
            return true;
        } else return hasNumbers.matches("\\d+");
    }

    public static boolean validString(String hasLetters) {
        if (hasLetters==null){
            return false;
        }
        return !hasLetters.matches("\\d+");
    }

    private static boolean empty(String id) {
        return id != null && !id.isEmpty();
    }

    public static boolean validId(String id) {
        if (!empty(id)) {
            return false;
        }
        if (!validNumber(id)) {
            return false;
        }
        if (id.length() > 7) {
            return false;
        }
        return Long.parseLong(id) != 0;
    }

    public static boolean validName(String name) {
        if (name == null) {
            return false;
        }
        if (name.isEmpty()) {
            return false;
        }
        if (name.equalsIgnoreCase("null")) {
            return false;
        }
        if (name.length() > 12) {
            return false;
        }
        if (Validator.validNumber(name)) {
            return false;
        }
        return validString(name);
    }

    public static boolean validGender(@ModelAttribute("gender") String gender) {
        return gender != null && (gender.equalsIgnoreCase("Male")
                | gender.equalsIgnoreCase("Female"));
    }

    public static boolean validEmail(String email) {
        if (email==null){
            return false;
        }
        return email.contains("@");
    }
}
