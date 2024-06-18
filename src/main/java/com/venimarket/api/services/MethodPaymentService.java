package com.venimarket.api.services;

import com.venimarket.api.domains.MethodPayment;
import com.venimarket.api.dtos.MethodPaymentDto;
import com.venimarket.api.repositories.MethodPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MethodPaymentService {
    @Autowired
    private MethodPaymentRepository methodPaymentRepository;

    public MethodPayment createMethodPayment(MethodPaymentDto methodPaymentDto){
        MethodPayment newMethodPayment = new MethodPayment();
        newMethodPayment.setTypesPayments(methodPaymentDto.typesPayments());
        this.methodPaymentRepository.save(newMethodPayment);
        return newMethodPayment;
    }
    public MethodPayment findMethodPaymentById(Long id) throws Exception {
        return this.methodPaymentRepository.findMethodPaymentById(id)
                .orElseThrow(()-> new Exception("Método de pagamento não encontrado"));
    }
}
