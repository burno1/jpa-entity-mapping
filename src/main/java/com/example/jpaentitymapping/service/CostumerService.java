package com.example.jpaentitymapping.service;

import com.example.jpaentitymapping.model.*;
import com.example.jpaentitymapping.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;
    public Customer save() {
        Address address = Address.builder()
                .street("street1")
                .build();

        Product bike = Product
                .builder()
                .name("bike")
                .build();

        Region region1 = Region
                .builder()
                .name("sao paulo")
                .build();
        List<Region> regions = Collections
                .singletonList(region1);

        Store store = Store
                .builder()
                .regions(regions)
                .products(Collections.singletonList(bike))
                .build();
        region1.setStores(Collections.singletonList(store));

        Sale sale1 = Sale
                .builder()
                .store(store)
                .fullValue(100)
                .build();
        store.setSales(Collections.singletonList(sale1));

        Customer bruno = Customer.builder()
                .address(address)
                .name("bruno")
                .sales(Collections
                        .singletonList(sale1))
                .address(address)
                .sales(Collections.singletonList(sale1))
                .build();
        sale1.setCustomer(bruno);

       return costumerRepository.save(bruno);
    }
}
