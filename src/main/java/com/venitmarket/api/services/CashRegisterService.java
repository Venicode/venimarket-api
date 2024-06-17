package com.venitmarket.api.services;

import com.venitmarket.api.domains.CashRegister;
import com.venitmarket.api.dtos.CashRegisterDto;
import com.venitmarket.api.repositories.CashRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CashRegisterService {
    @Autowired
    private CashRegisterRepository cashRegisterRepository;

    public CashRegister createCashRegister(double balance){
        CashRegister newCashRegister = new CashRegister();
        newCashRegister.setDate(LocalDateTime.now());
        newCashRegister.setBalance(newCashRegister.getBalance()+balance);
        this.cashRegisterRepository.save(newCashRegister);
        return newCashRegister;
    }
}
