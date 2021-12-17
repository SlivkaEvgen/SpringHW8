package org.goit.springhw8.util.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.goit.springhw8.util.annotations.validators.PriceValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PriceValidator.class)
@Documented
public @interface PriceValid {

    String message() default "Invalid price";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
