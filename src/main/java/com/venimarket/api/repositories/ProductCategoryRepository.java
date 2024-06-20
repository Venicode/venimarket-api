package com.venimarket.api.repositories;

import com.venimarket.api.domains.ProductCategory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Transactional
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    Optional<ProductCategory> findProductCategoryById(Long id);
    @Modifying
    @Query("""
            delete ProductCategory p
            where p.id = :id
            """)
    void deleteProductCategory(Long id);
}
