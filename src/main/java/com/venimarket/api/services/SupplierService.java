package com.venimarket.api.services;

import com.venimarket.api.domains.Supplier;
import com.venimarket.api.dtos.SupplierDto;
import com.venimarket.api.repositories.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Supplier updateSupplier(SupplierDto supplierDto, Long id) throws Exception {
        Supplier newSupplier = findSupplierById(id);
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
                .orElseThrow(()-> new EntityNotFoundException("Supplier not found."));

    }

    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> supplierList = this.supplierRepository.findAll();
        return new ResponseEntity<>(supplierList, HttpStatus.OK);
    }
    public void disableSupplier(Long id){
        this.supplierRepository.disableSupplier(id);
    }
}
