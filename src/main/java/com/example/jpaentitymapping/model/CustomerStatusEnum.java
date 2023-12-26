package com.example.jpaentitymapping.model;


import com.example.jpaentitymapping.validator.EnumValidationBase;
import lombok.Getter;

@Getter
public enum CustomerStatusEnum implements EnumValidationBase {
    ACTIVE("active"),
    INACTIVE("inactive");

    private final String value;

    CustomerStatusEnum(String value) {
        this.value = value;
    }

    @Override
    public String getValueValidation() {
        return String.valueOf(value);
    }
}
