package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.MethodPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MethodPaymentRepository extends JpaRepository<MethodPayment, Long> {
}
