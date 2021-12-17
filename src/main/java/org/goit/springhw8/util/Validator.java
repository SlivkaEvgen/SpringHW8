package org.goit.springhw8.util;

import org.springframework.web.bind.annotation.ModelAttribute;

//@Component
public class Validator {

    public static boolean validString(String hasLetters) {
        return hasLetters != null && !hasLetters.matches("\\d+")&&hasLetters.matches("^[^\\s]+(\\s+[^\\s]+)*$");
    }

    private static boolean empty(String attribute) {
        return attribute != null && !attribute.isEmpty();
    }

    public static boolean validId(@ModelAttribute("id") String id) {
        return empty(id) && validNumber(id) && id.length() < 10;}

    public static boolean validName(@ModelAttribute("name") String name) {
        return empty(name) &&
                !name.equalsIgnoreCase("null") &&
                name.length() <= 15 &&
                !Validator.validNumber(name) &&
                validString(name);
    }

    public static boolean validEmail(@ModelAttribute("email") String email) {
        return empty(email) && email.matches("/^[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}$/i");
    }

    private static boolean validNumber(String hasNumbers) {
        return  empty(hasNumbers)&&hasNumbers.matches("\\d+")&&hasNumbers.matches("^[^\\s]+(\\s+[^\\s]+)*$");
    }

    public static boolean isValidPrice(@ModelAttribute("price") String price){
        return price!=null &&
                !price.contains(",") &&
                price.matches("[0-9]+([,.][0-9]{1,2})?");
    }
}
//    private static boolean isValidNumbers(String isNumber){
//        return empty(isNumber) && isNumber.matches("/^\\d{1,}$/");
//    }