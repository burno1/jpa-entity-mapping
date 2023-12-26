package com.example.jpaentitymapping.controller;

import com.example.jpaentitymapping.model.Customer;
import com.example.jpaentitymapping.model.CustomerDto;
import com.example.jpaentitymapping.service.CustumerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CostumerController {

    @Autowired
    private CustumerService customerService;

    @PostMapping
    public ResponseEntity<Customer> postCustomer(@Valid @RequestBody CustomerDto customerDto){
        try{
            return new ResponseEntity(customerService.save(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);}
    }

}
