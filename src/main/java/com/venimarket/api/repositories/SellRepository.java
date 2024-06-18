package com.venimarket.api.repositories;

import com.venimarket.api.domains.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, Long> {
}
