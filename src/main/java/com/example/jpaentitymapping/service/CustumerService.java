package com.example.jpaentitymapping.service;

import com.example.jpaentitymapping.model.*;
import com.example.jpaentitymapping.repository.CostumerRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class CustumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    @Autowired
    private Validator validator;

    @Transactional(rollbackOn = RuntimeException.class, dontRollbackOn = CustomerException.class)
    public Customer save() {

        Customer bruno = generateCustomer();
        Customer customer = new Customer();

        Set<ConstraintViolation<Customer>> validate = validator.validate(bruno);
        if (!validate.isEmpty()) {
            throw new CustomerException();
        }

        customer = costumerRepository.save(bruno);
        return customer;
    }

    private static Customer generateCustomer() {
        Address address = Address.builder()
                .street("valor")
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
                .customerStatusEnum(CustomerStatusEnum.ACTIVE.getValue())
                .build();
        sale1.setCustomer(bruno);

        return bruno;
    }
}
