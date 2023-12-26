package com.example.jpaentitymapping.model;

import com.example.jpaentitymapping.validator.EnumValidator;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import static com.example.jpaentitymapping.contant.ErrorMessages.LIST_SIZE_ERROR;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer  implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotBlank(groups = {AsynGroup.class})
        private String name;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        @EqualsAndHashCode.Exclude
        @ToString.Exclude
        @Valid
        private List<Sale> sales;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "address_id")
        @Valid
        private Address address;


        @EnumValidator(enumT = CustomerStatusEnum.class)
        private String customerStatusEnum;
}
