package com.venimarket.api.repositories;

import com.venimarket.api.domains.MethodPayment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Transactional
public interface MethodPaymentRepository extends JpaRepository<MethodPayment, Long> {
    Optional<MethodPayment> findMethodPaymentById(Long id);
    Optional<MethodPayment> findMethodPaymentByDescriptionMethodPayment(String descriptionMethodPayment);
    @Modifying
    @Query("""
            delete MethodPayment m
            where m.id = :id
            """)
    void deleteMethodPayment(Long id);
}
