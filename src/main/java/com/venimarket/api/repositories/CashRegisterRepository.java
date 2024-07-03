package com.venimarket.api.repositories;

import com.venimarket.api.domains.CashRegister;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

@Transactional
public interface CashRegisterRepository extends JpaRepository<CashRegister, Long> {
    @Modifying
    @Query("""
            update CashRegister c
            set c.balance = :balance
            where c.id = :id
            """)
    void addBalance(double balance,Long id);

    @Modifying
    @Query("""
            update CashRegister c
            set c.isClosed = true,
            c.finalDate = :finalDate
            where c.id = :id
            """)
    void closeCashRegister(Long id, LocalDateTime finalDate);

    @Query("""
            select max(balance) c from CashRegister c
            """)
    Object getLastBalance();

    @Query("""
            select c from CashRegister c
            where c.initialDate between
            :dateOne and :dateTwo
            order by c.finalDate
            limit 1
            """)
    CashRegister findAtualCashRegister(LocalDateTime dateOne, LocalDateTime dateTwo);
    CashRegister findAllByIsClosedFalse();
}
