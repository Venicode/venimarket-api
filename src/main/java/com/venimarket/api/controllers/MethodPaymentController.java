package com.venimarket.api.controllers;

import com.venimarket.api.services.MethodPaymentService;
import com.venimarket.api.domains.MethodPayment;
import com.venimarket.api.dtos.MethodPaymentDto;
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
