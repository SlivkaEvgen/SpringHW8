package org.goit.springhw8.util.annotations.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.goit.springhw8.util.annotations.PriceValid;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Price validator.
 */
public class PriceValidator implements ConstraintValidator<PriceValid, String> {

    private static final String PRICE_PATTERN = "/(\\[0-9,]+(\\.[0-9]{2})?)/";

    @Override
    public void initialize(PriceValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(@ModelAttribute("price") String price, ConstraintValidatorContext context) {
        return validatePrice(price);
    }

    private boolean validatePrice(@ModelAttribute("price") String price) {
        Pattern pattern = Pattern.compile(PRICE_PATTERN);
        Matcher matcher = pattern.matcher(price);
        return matcher.matches();
    }
}
