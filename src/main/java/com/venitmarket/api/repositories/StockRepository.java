package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
