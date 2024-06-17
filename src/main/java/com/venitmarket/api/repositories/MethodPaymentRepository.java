package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.MethodPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MethodPaymentRepository extends JpaRepository<MethodPayment, Long> {
    Optional<MethodPayment> findMethodPaymentById(Long id);
}
