package com.example.jpaentitymapping.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumValidationConstraint.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EnumValidator {

    Class<? extends EnumValidationBase> enumT();

    String message() default "Invalid enum type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
