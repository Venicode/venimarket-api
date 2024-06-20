package com.venimarket.api.services;

import com.venimarket.api.domains.ProductCategory;
import com.venimarket.api.dtos.ProductCategoryDto;
import com.venimarket.api.repositories.ProductCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory createProductCategory(ProductCategoryDto productCategoryDto){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setDescriptionCategory(productCategory.getDescriptionCategory());
        this.productCategoryRepository.save(productCategory);
        return productCategory;
    }
    public ProductCategory findProductCategoryById(Long id){
        return this.productCategoryRepository.findProductCategoryById(id)
                .orElseThrow(()-> new EntityNotFoundException("Product category not found."));
    }
    public ResponseEntity<List<ProductCategory>> getAllProductCategories(){
        List<ProductCategory> productCategoryList =  this.productCategoryRepository.findAll();
        return new ResponseEntity<>(productCategoryList, HttpStatus.OK);
    }
    public ProductCategory updateProductCategory(ProductCategoryDto productCategoryDto, Long id){
        ProductCategory productCategory = findProductCategoryById(id);
        productCategory.setDescriptionCategory(productCategoryDto.descriptionCategory());
        this.productCategoryRepository.save(productCategory);
        return productCategory;
    }
    public void deleteProductCategory(Long id){
        this.productCategoryRepository.deleteProductCategory(id);
    }
}
