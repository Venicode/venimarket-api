package com.venitmarket.api.services;

import com.venitmarket.api.domains.Customer;
import com.venitmarket.api.dtos.CustomerDto;
import com.venitmarket.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .orElseThrow(()-> new Exception("Cliente não encontrado"));

    }
}
