package com.venitmarket.api.repositories;

import com.venitmarket.api.domains.CashRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRegisterRepository extends JpaRepository<CashRegister, Long> {
}
