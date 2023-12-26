package com.example.jpaentitymapping.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidationConstraint implements ConstraintValidator<EnumValidator, Object> {

    Set<String> values;

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

        Set<String> badWords = new HashSet<>();
        badWords.add("casa");
        badWords.add("teto");

        values = badWords;
//        values = Stream.of(constraintAnnotation.enumT().getEnumConstants())
//                .map(EnumValidationBase::getValueValidation)
//                .collect(Collectors.toSet());
//
//        if (values.stream().anyMatch(Objects::isNull)) {
//            final Class<? extends Enum<?>> enumClass = (Class<? extends Enum<?>>) constraintAnnotation.enumT();
//
//            values = Stream.of(enumClass.getEnumConstants()).map(Enum::name).collect(Collectors.toSet());
//        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        return values == null || !values.contains(String.valueOf(value));
    }
}
