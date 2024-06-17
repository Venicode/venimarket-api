package com.venitmarket.api.controllers;

import com.venitmarket.api.domains.Supplier;
import com.venitmarket.api.dtos.SupplierDto;
import com.venitmarket.api.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody SupplierDto supplierDto) throws Exception{
        Supplier newSupplier = this.supplierService.createSupplier(supplierDto);
        return new ResponseEntity<>(newSupplier, HttpStatus.CREATED);
    }
}
