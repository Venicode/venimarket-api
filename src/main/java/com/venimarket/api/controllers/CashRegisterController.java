package com.venimarket.api.controllers;

import com.venimarket.api.domains.CashRegister;
import com.venimarket.api.services.CashRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashRegister")
public class CashRegisterController {
    @Autowired
    private CashRegisterService cashRegisterService;

    @DeleteMapping("/{id}")
    public ResponseEntity<CashRegister> closeCashRegister(@PathVariable Long id){
        return this.cashRegisterService.closeCashRegister(id);
    }
    @GetMapping
    public ResponseEntity<List<CashRegister>> getAllCashRegisters(){
        return this.cashRegisterService.getAllCashRegisters();
    }
}
