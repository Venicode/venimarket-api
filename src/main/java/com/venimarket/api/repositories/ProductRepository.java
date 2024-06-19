package com.venimarket.api.repositories;

import com.venimarket.api.domains.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductById(Long id);
    @Modifying
    @Query("""
            update Product p
            set p.isActive = false
            where p.id = :id
            """)
    void disableProduct(Long id);
}
