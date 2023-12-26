package com.example.jpaentitymapping.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

import static com.example.jpaentitymapping.contant.ErrorMessages.MIN_VALUE;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Valid
    private Store store;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @Min(value = 1, message = MIN_VALUE)
    private Integer fullValue;


}
