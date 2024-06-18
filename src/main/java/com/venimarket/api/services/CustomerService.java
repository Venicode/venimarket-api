package com.venimarket.api.services;

import com.venimarket.api.domains.Customer;
import com.venimarket.api.dtos.CustomerDto;
import com.venimarket.api.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(CustomerDto customerDto) throws Exception{
       Customer newCustomer = new Customer();
       newCustomer.setCpf(customerDto.cpf());
       newCustomer.setEmail(customerDto.email());
       newCustomer.setPhone(customerDto.phone());
       newCustomer.setFirstName(customerDto.firstName());
       newCustomer.setLastName(customerDto.lastName());

       this.customerRepository.save(newCustomer);
       return newCustomer;
    }
    public Customer findCustomerById(Long id) throws Exception{
        return this.customerRepository.findCustomerById(id)
                .orElseThrow(()-> new EntityNotFoundException("Cliente não encontrado"));

    }

    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = this.customerRepository.findAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
