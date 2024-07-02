package com.venimarket.api.controllers;

import com.venimarket.api.domains.Order;
import com.venimarket.api.dtos.OrderDto;
import com.venimarket.api.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createSell(@RequestBody @Valid OrderDto orderDto) throws Exception{
        Order order = this.orderService.createOrder(orderDto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return this.orderService.getAllOrders();
    }
}
