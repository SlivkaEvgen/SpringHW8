package org.goit.springhw8.util;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
public class Validator {

    public static boolean validNumber(String hasNumbers) {
        if (!validString(hasNumbers)) {
            return true;
        } else return hasNumbers.matches("\\d+");
    }

    public static boolean validString(@NonNull String hasLetters) {
        return !hasLetters.matches("\\d+");
    }

    private static boolean empty(@NonNull String id) {
        return !id.isEmpty();
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

    public static boolean validName(@NonNull String name) {
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

    public static boolean validGender(@NonNull String gender) {
        return (gender.equalsIgnoreCase("Male")
                | gender.equalsIgnoreCase("Female"));
    }

    public static boolean validEmail(@NonNull String email) {
        return email.contains("@");
    }

//    @Override
//    public void validate(@NotNull Object target, @NotNull Errors errors, @NotNull Object... validationHints) {
//        System.out.println("Validator validate");
//
//    }
//
//    @Override
//    public void validateValue(@NotNull Class<?> targetType, @NotNull String fieldName, Object value, @NotNull Errors errors, @NotNull Object... validationHints) {
//        System.out.println("Validator validateValue");
//
//        SmartValidator.super.validateValue(targetType, fieldName, value, errors, validationHints);
//    }
//
//    @Override
//    public boolean supports(@NotNull Class<?> clazz) {
//        System.out.println("Validator supports");
//
//        return false;
//    }
//
//    @Override
//    public void validate(@NotNull Object target, @NotNull Errors errors) {
//        System.out.println("Validator validate");
//
//    }
}
