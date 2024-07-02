package com.venimarket.api.controllers;

import com.venimarket.api.domains.ItemOrder;
import com.venimarket.api.dtos.ItemOrderDto;
import com.venimarket.api.services.ItemOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/itemorder")
public class ItemOrderController {
    @Autowired
    private ItemOrderService itemOrderService;

    @PostMapping
    public ResponseEntity<ItemOrder> createSell(@RequestBody @Valid ItemOrderDto itemOrderDto) throws Exception{
        ItemOrder itemOrder = this.itemOrderService.createItemOrder(itemOrderDto);
        return new ResponseEntity<>(itemOrder, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ItemOrder>> getAllItemOrders(){
        return this.itemOrderService.getAllItemOrders();
    }
}
