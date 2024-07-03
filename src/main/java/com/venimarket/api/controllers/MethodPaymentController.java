package com.venimarket.api.controllers;

import com.venimarket.api.services.MethodPaymentService;
import com.venimarket.api.domains.MethodPayment;
import com.venimarket.api.dtos.MethodPaymentDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/methodPayment")
public class MethodPaymentController {
    @Autowired
    private MethodPaymentService methodPaymentService;
    @PostMapping
    public ResponseEntity<MethodPayment> createMethodPayment(@RequestBody @Valid MethodPaymentDto methodPaymentDto){
        MethodPayment newMethodPayment = this.methodPaymentService.createMethodPayment(methodPaymentDto);
        return new ResponseEntity<>(newMethodPayment, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<MethodPayment>> getAllMethodPayments(){
        return this.methodPaymentService.getAllMethodPayments();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MethodPayment> getMethodPaymentById(@PathVariable Long id) throws Exception {
       MethodPayment methodPayment = methodPaymentService.findMethodPaymentById(id);
       return new ResponseEntity<>(methodPayment, HttpStatus.OK);
    }
    @GetMapping("/descriptionMethodPayment/{descriptionMethodPayment}")
    public ResponseEntity<MethodPayment> getMethodPaymentByDescriptionMethodPayment(@PathVariable String descriptionMethodPayment) throws Exception {
        MethodPayment methodPayment = methodPaymentService.findMethodPaymentByDescriptionMethodPayment(descriptionMethodPayment);
        return new ResponseEntity<>(methodPayment, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MethodPayment> updateMethodPayment(@RequestBody @Valid MethodPaymentDto methodPaymentDto, @PathVariable Long id) throws Exception {
        MethodPayment newMethodPayment = this.methodPaymentService.updateMethodPayment(methodPaymentDto, id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMethodPayment(@PathVariable Long id){
        this.methodPaymentService.deleteMethodPayment(id);
        return ResponseEntity.noContent().build();
    }
}
