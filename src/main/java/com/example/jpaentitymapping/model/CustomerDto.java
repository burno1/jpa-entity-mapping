package com.example.jpaentitymapping.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDto implements Serializable {

    private Long id;

    private String name;
    private Address address;
}
