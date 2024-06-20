package com.venimarket.api.services;

import com.venimarket.api.domains.MethodPayment;
import com.venimarket.api.dtos.MethodPaymentDto;
import com.venimarket.api.repositories.MethodPaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodPaymentService {
    @Autowired
    private MethodPaymentRepository methodPaymentRepository;

    public MethodPayment createMethodPayment(MethodPaymentDto methodPaymentDto){
        MethodPayment newMethodPayment = new MethodPayment();
        newMethodPayment.setDescriptionMethodPayment(methodPaymentDto.typesPayments());
        this.methodPaymentRepository.save(newMethodPayment);
        return newMethodPayment;
    }
    public MethodPayment updateMethodPayment(MethodPaymentDto methodPaymentDto, Long id) throws Exception {
        MethodPayment newMethodPayment = findMethodPaymentById(id);
        newMethodPayment.setDescriptionMethodPayment(methodPaymentDto.typesPayments());
        this.methodPaymentRepository.save(newMethodPayment);
        return newMethodPayment;
    }
    public MethodPayment findMethodPaymentById(Long id) throws Exception {
        return this.methodPaymentRepository.findMethodPaymentById(id)
                .orElseThrow(()-> new EntityNotFoundException("Method Payment not found."));
    }

    public ResponseEntity<List<MethodPayment>> getAllMethodPayments() {
        List<MethodPayment> methodPaymentList = this.methodPaymentRepository.findAll();
        return  new ResponseEntity<>(methodPaymentList, HttpStatus.OK);
    }
    public void deleteMethodPayment(Long id){
        this.methodPaymentRepository.deleteMethodPayment(id);
    }
}
