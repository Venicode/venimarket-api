package com.venimarket.api.services;

import com.venimarket.api.domains.CashRegister;
import com.venimarket.api.repositories.CashRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CashRegisterService {
    @Autowired
    private CashRegisterRepository cashRegisterRepository;

    public void openCashRegister(double newBalance) throws Exception {
        CashRegister newCashRegister = new CashRegister();
        double balance = newBalance;
        if(this.cashRegisterRepository.getLastBalance() != null){
            balance += Double.parseDouble(this.cashRegisterRepository.getLastBalance().toString());
        }
        newCashRegister.setInitialDate(LocalDateTime.now());
        newCashRegister.setBalance(balance);
        this.cashRegisterRepository.save(newCashRegister);
    }

    public void addBalanceCashRegister(double balance, LocalDateTime dateSell) throws Exception {
        LocalDate dateFormmated = dateSell.toLocalDate();
        LocalDateTime initialDate = dateFormmated.atStartOfDay();
        if(this.cashRegisterRepository.findAtualCashRegister(initialDate, dateSell)==null){
            openCashRegister(balance);
        } else{
            CashRegister cashRegister = this.cashRegisterRepository.findAtualCashRegister(initialDate, dateSell);
            if(cashRegister.isClosed()){
                openCashRegister(balance);
            }
            else{
                double newBalance = cashRegister.getBalance() + balance;
                this.cashRegisterRepository.addBalance(newBalance, cashRegister.getId());
            }
        }
    }

    public ResponseEntity<List<CashRegister>> getAllCashRegisters(){
        List<CashRegister> cashRegisters = this.cashRegisterRepository.findAll();
        return new ResponseEntity<>(cashRegisters, HttpStatus.OK);
    }

    public ResponseEntity<CashRegister> closeCashRegister(Long id) {
        this.cashRegisterRepository.closeCashRegister(id, LocalDateTime.now());
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<List<CashRegister>> findAllByIsClosedFalse() {
        this.cashRegisterRepository.findAllByIsClosedFalse();
        return ResponseEntity.noContent().build();
    }
}
