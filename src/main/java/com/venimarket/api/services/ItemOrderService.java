package com.venimarket.api.services;

import com.venimarket.api.domains.*;
import com.venimarket.api.dtos.ItemOrderDto;
import com.venimarket.api.infra.exceptions.InsufficientAmountException;
import com.venimarket.api.infra.exceptions.InsufficientQuantityException;
import com.venimarket.api.repositories.ItemOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemOrderService {
    @Autowired
    private ItemOrderRepository itemOrderRepository;

    @Autowired
    private CashRegisterService cashRegisterService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private StockService stockService;

    public ItemOrder createItemOrder(ItemOrderDto itemOrderDto) throws Exception {
        Order order = orderService.findOrderById(itemOrderDto.id_order());
        Product product = this.productService.findProductById(itemOrderDto.id_product());
        double amountTotal = ((product.getSellingPrice() * itemOrderDto.quantity()) - itemOrderDto.discount());

        ItemOrder itemOrder = new ItemOrder();

        if (itemOrderDto.amount() < amountTotal) {
            throw new InsufficientAmountException("Insufficient amount.");
        }
        if ((itemOrderDto.amount() - itemOrderDto.discount()) != amountTotal) {
            throw new InsufficientAmountException("More amount than necessary.");
        }
        if (itemOrderDto.quantity() > product.getQuantity()) {
            throw new InsufficientQuantityException("Insufficient quantity in stock.");
        }
        itemOrder.setOrder(order);
        itemOrder.setAmount(itemOrderDto.amount());
        itemOrder.setProduct(product);
        itemOrder.setQuantity(itemOrderDto.quantity());
        itemOrder.setDiscount(itemOrderDto.discount());
        order.setSellDate(LocalDateTime.now());

        this.itemOrderRepository.save(itemOrder);

        this.cashRegisterService.addBalanceCashRegister(amountTotal, order.getSellDate());
        this.stockService.updateStock(product.getQuantity() - itemOrderDto.quantity(), product);
        return itemOrder;
    }

    public ResponseEntity<List<ItemOrder>> getAllItemOrders() {
        List<ItemOrder> orderList = this.itemOrderRepository.findAll();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }
}
