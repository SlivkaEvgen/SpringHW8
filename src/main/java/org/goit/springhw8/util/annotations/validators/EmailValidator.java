package org.goit.springhw8.util.annotations.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.goit.springhw8.util.annotations.ValidEmail;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Email validator.
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(@ModelAttribute("email") String email, ConstraintValidatorContext context) {
        return (validateEmail(email));
    }

    private boolean validateEmail(@ModelAttribute("email") String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
