package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, Long> {
}
