package com.example.jpaentitymapping.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer  implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String name;

        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        @EqualsAndHashCode.Exclude
        @ToString.Exclude
        private List<Sale> sales;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "address_id")
        private Address address;
}
