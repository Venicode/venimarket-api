package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerById(Long id);
}
