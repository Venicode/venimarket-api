package com.venimarket.api.controllers;

import com.venimarket.api.domains.Supplier;
import com.venimarket.api.dtos.SupplierDto;
import com.venimarket.api.services.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody @Valid SupplierDto supplierDto) throws Exception{
        Supplier newSupplier = this.supplierService.createSupplier(supplierDto);
        return new ResponseEntity<>(newSupplier, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        return this.supplierService.getAllSuppliers();
    }
}
