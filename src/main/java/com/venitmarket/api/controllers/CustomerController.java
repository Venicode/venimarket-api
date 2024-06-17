package com.venitmarket.api.controllers;

import com.venitmarket.api.domains.Customer;
import com.venitmarket.api.dtos.CustomerDto;
import com.venitmarket.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto) throws Exception{
        Customer newCustomer = this.customerService.createCustomer(customerDto);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }
}
