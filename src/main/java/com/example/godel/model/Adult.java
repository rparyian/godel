package com.example.godel.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = AdultValidator.class)
@Documented
public @interface Adult {
    String message() default "{no adult}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
