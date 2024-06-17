package com.venitmarket.api.services;

import com.venitmarket.api.domains.Supplier;
import com.venitmarket.api.dtos.SupplierDto;
import com.venitmarket.api.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier createSupplier(SupplierDto supplierDto){
        Supplier newSupplier = new Supplier();
        newSupplier.setCnpj(supplierDto.cnpj());
        newSupplier.setEmail(supplierDto.email());
        newSupplier.setPhone(supplierDto.phone());
        newSupplier.setTradeName(supplierDto.tradeName());
        newSupplier.setCorporateName(supplierDto.corporateName());

        this.supplierRepository.save(newSupplier);
        return newSupplier;
    }
    public Supplier findSupplierById(Long id) throws Exception{
        return this.supplierRepository.findSupplierById(id)
                .orElseThrow(()-> new Exception("Fornecedor não encontrado"));

    }
}
