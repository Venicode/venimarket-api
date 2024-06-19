package com.venimarket.api.repositories;

import com.venimarket.api.domains.Supplier;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Transactional
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findSupplierById(Long id);
    @Modifying
    @Query("""
            update Supplier s
            set s.isActive = false
            where s.id = :id
            """)
    void disableSupplier(Long id);
}
