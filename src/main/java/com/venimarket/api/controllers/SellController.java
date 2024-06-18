package com.venimarket.api.controllers;

import com.venimarket.api.domains.Sell;
import com.venimarket.api.dtos.SellDto;
import com.venimarket.api.services.SellService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private SellService sellService;

    @PostMapping
    public ResponseEntity<Sell> createSell(@RequestBody @Valid SellDto sellDto) throws Exception{
        Sell newSell = this.sellService.createSell(sellDto);
        return new ResponseEntity<>(newSell, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Sell>> getAllSells(){
        return this.sellService.getAllSells();
    }
}
