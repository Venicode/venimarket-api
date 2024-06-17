package com.venitmarket.api.controllers;

import com.venitmarket.api.domains.Product;
import com.venitmarket.api.domains.Sell;
import com.venitmarket.api.dtos.ProductDto;
import com.venitmarket.api.dtos.SellDto;
import com.venitmarket.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) throws Exception{
        Product newProduct = this.productService.createProduct(productDto);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}
