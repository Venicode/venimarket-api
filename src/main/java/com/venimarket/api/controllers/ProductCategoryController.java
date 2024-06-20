package com.venimarket.api.controllers;

import com.venimarket.api.domains.ProductCategory;
import com.venimarket.api.dtos.ProductCategoryDto;
import com.venimarket.api.services.ProductCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody @Valid ProductCategoryDto productCategoryDto){
        ProductCategory productCategory = this.productCategoryService.createProductCategory(productCategoryDto);
        return new ResponseEntity<>(productCategory, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProductCategories(){
        return this.productCategoryService.getAllProductCategories();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@RequestBody @Valid ProductCategoryDto productCategoryDto, @PathVariable Long id) throws Exception {
        ProductCategory productCategory = this.productCategoryService.updateProductCategory(productCategoryDto, id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductCategory(@PathVariable Long id){
        this.productCategoryService.deleteProductCategory(id);
        return ResponseEntity.noContent().build();
    }
}
