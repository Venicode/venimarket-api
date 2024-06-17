package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Modifying
    @Query("""
            update Stock s
            set s.quantity = :quantity
            where s.product.getIdProduct() = :idProduct
            """)
    void updateQuantity(Long idProduct, int quantity);
}
