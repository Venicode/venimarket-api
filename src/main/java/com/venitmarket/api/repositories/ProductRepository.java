package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
