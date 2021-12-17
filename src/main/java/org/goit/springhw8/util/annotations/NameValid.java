package org.goit.springhw8.util.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.goit.springhw8.util.annotations.validators.NameValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface NameValid {

    String message() default "Name not null,not Empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
