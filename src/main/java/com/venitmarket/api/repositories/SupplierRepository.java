package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
