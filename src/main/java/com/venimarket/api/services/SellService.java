package com.venimarket.api.services;

import com.venimarket.api.domains.Customer;
import com.venimarket.api.domains.MethodPayment;
import com.venimarket.api.domains.Product;
import com.venimarket.api.domains.Sell;
import com.venimarket.api.dtos.SellDto;
import com.venimarket.api.repositories.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
            throw new Exception("Valor inferior a compra");
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
}
