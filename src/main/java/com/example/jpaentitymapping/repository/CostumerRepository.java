package com.example.jpaentitymapping.repository;

import com.example.jpaentitymapping.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Customer, Long> {
}
