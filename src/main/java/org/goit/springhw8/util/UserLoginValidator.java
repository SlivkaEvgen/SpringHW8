//package org.goit.springhw8.util;
//
//import org.goit.springhw8.model.User;
//import org.goit.springhw8.service.UserService;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.validation.Errors;
//import org.springframework.validation.SmartValidator;
//import org.springframework.validation.ValidationUtils;
//
//public class UserLoginValidator extends Validator {
//
//    private static final int MINIMUM_PASSWORD_LENGTH = 6;
//
//    public UserLoginValidator(SmartValidator smartValidator) {
//        super(smartValidator);
//    }
//
//    public boolean supports(@NotNull Class clazz) {
//        return UserService.class.isAssignableFrom(clazz);
//    }
//
//    public void validate(@NotNull Object target, @NotNull Errors errors) {
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "field.required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
//        User login = (User) target;
//        if (login.getPassword() != null
//                && login.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {
//            errors.rejectValue("password", "field.min.length",
//                    new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},
//                    "The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
//        }
//    }
//}