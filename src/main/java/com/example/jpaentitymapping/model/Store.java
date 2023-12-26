package com.example.jpaentitymapping.model;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import static com.example.jpaentitymapping.contant.ErrorMessages.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @NotNull
    @Size(min = 1, message = STORE_EMPTY_ERROR)
    private List<Product> products;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Sale> sales;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "storeRegions",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Size(min = 1, message = REGION_MIN_ERROR)
    @Valid
    private List<Region> regions;


}
