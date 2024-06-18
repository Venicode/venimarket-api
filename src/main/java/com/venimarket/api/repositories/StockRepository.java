package com.venimarket.api.repositories;

import com.venimarket.api.domains.Product;
import com.venimarket.api.domains.Stock;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Transactional
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Modifying
    @Query("""
            update Stock s
            set s.quantity = :quantity
            where s.product = :product
            """)
    void updateQuantity(int quantity, Product product);
}
