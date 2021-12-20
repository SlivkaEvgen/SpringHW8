package org.goit.springhw8.util.annotations.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.goit.springhw8.model.dto.UserDto;
import org.goit.springhw8.util.annotations.PasswordMatches;
import org.springframework.validation.annotation.Validated;

/**
 * The type Password validator.
 */
@Validated
public class PasswordValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
