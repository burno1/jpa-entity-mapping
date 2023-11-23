package com.example.jpaentitymapping.controller;

import com.example.jpaentitymapping.model.Customer;
import com.example.jpaentitymapping.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @PostMapping
    public ResponseEntity<Customer> testCostumer(){
        return new ResponseEntity(costumerService.save(), HttpStatus.OK);
    }

}
