package org.goit.springhw8.util.annotations.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.goit.springhw8.util.Validator;
import org.goit.springhw8.util.annotations.NameValid;
import org.springframework.web.bind.annotation.ModelAttribute;

public class NameValidator implements ConstraintValidator<NameValid,String> {

    @Override
    public void initialize(NameValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(@ModelAttribute("name") String name, ConstraintValidatorContext context) {
        return (validName(name));
    }

    private boolean validName(@ModelAttribute("name") String name){
        return name != null &&
                !name.isEmpty() &&
                !name.equalsIgnoreCase("null") &&
                name.length() <= 12 &&
                !Validator.validName(name) &&
                validString(name);
    }

    private boolean validString(String hasLetters) {
        return hasLetters != null && !hasLetters.matches("\\d+");
    }
}
