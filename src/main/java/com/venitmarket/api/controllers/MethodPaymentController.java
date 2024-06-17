package com.venitmarket.api.controllers;

import com.venitmarket.api.domains.MethodPayment;
import com.venitmarket.api.dtos.MethodPaymentDto;
import com.venitmarket.api.services.MethodPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methodPayment")
public class MethodPaymentController {
    @Autowired
    private MethodPaymentService methodPaymentService;
    @PostMapping
    public ResponseEntity<MethodPayment> createMethodPayment(@RequestBody MethodPaymentDto methodPaymentDto){
        MethodPayment newMethodPayment = this.methodPaymentService.createMethodPayment(methodPaymentDto);
        return new ResponseEntity<>(newMethodPayment, HttpStatus.CREATED);
    }
}
