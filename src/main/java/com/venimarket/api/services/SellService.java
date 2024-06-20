package com.venimarket.api.services;

import com.venimarket.api.domains.Customer;
import com.venimarket.api.domains.MethodPayment;
import com.venimarket.api.domains.Product;
import com.venimarket.api.domains.Sell;
import com.venimarket.api.dtos.SellDto;
import com.venimarket.api.infra.exceptions.InsufficientAmountException;
import com.venimarket.api.infra.exceptions.InsufficientQuantityException;
import com.venimarket.api.repositories.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SellService {
    @Autowired
    private SellRepository sellRepository;

    @Autowired
    private CashRegisterService cashRegisterService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MethodPaymentService methodPaymentService;
    @Autowired
    private StockService stockService;

    public Sell createSell(SellDto sellDto) throws Exception {
        Product product = this.productService.findProductById(sellDto.id_product());
        double amountTotal = product.getSellingPrice()*sellDto.quantity();
        MethodPayment newMethodPayment = methodPaymentService
                .findMethodPaymentById(sellDto.id_methodPayment());
        Customer customer = this.customerService.findCustomerById(sellDto.id_customer());
        Sell newSell = new Sell();

        if(sellDto.amount()<amountTotal){
            throw new InsufficientAmountException("Insufficient amount.");
        }
        if(sellDto.quantity()> product.getQuantity()){
            throw new InsufficientQuantityException("Insufficient quantity in stock.");
        }

        newSell.setAmount(sellDto.amount());
        newSell.setProduct(product);
        newSell.setQuantity(sellDto.quantity());
        newSell.setMethodPayment(newMethodPayment);
        newSell.setCustomer(customer);
        newSell.setSellDate(LocalDateTime.now());

        this.sellRepository.save(newSell);

        this.cashRegisterService.addBalanceCashRegister(sellDto.amount(), newSell.getSellDate());
        this.stockService.updateStock(product.getQuantity()- sellDto.quantity(), product);
        return newSell;
    }

    public ResponseEntity<List<Sell>> getAllSells() {
        List<Sell> sellList = this.sellRepository.findAll();
        return new ResponseEntity<>(sellList, HttpStatus.OK);
    }
}
