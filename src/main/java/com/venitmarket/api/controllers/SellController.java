package com.venitmarket.api.controllers;

import com.venitmarket.api.domains.Sell;
import com.venitmarket.api.dtos.SellDto;
import com.venitmarket.api.services.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private SellService sellService;

    @PostMapping
    public ResponseEntity<Sell> createSell(@RequestBody SellDto sellDto) throws Exception{
        Sell newSell = this.sellService.createSell(sellDto);
        return new ResponseEntity<>(newSell, HttpStatus.OK);
    }
}
