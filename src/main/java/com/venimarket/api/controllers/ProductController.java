package com.venimarket.api.controllers;

import com.venimarket.api.domains.Product;
import com.venimarket.api.dtos.ProductDto;
import com.venimarket.api.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDto productDto) throws Exception{
        Product newProduct = this.productService.createProduct(productDto);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return this.productService.getAllProducts();
    }
    @GetMapping("/{barcode}")
    public ResponseEntity<Product> getProductByBarCode(@PathVariable Long barcode) throws Exception {
        Product product = this.productService.findProductByIBarCode(barcode);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody @Valid ProductDto productDto, @PathVariable Long id) throws Exception{
        Product newProduct = this.productService.updateProduct(productDto, id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> disableProduct(@PathVariable Long id){
        this.productService.disableProduct(id);
        return ResponseEntity.noContent().build();
    }
}
