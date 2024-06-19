package com.venimarket.api.repositories;

import com.venimarket.api.domains.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerById(Long id);
    @Modifying
    @Query("""
            update Customer c
            set c.isActive = false
            where c.id = :id
            """)
    void disableCustomer(Long id);
}
