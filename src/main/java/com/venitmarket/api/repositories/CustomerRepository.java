package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
