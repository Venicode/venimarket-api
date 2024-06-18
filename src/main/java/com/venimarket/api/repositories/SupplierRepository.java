package com.venimarket.api.repositories;

import com.venimarket.api.domains.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findSupplierById(Long id);
}
