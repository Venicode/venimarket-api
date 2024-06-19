package com.venimarket.api.services;

import com.venimarket.api.domains.Product;
import com.venimarket.api.domains.Supplier;
import com.venimarket.api.dtos.ProductDto;
import com.venimarket.api.dtos.StockDto;
import com.venimarket.api.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private StockService stockService;
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductDto productDto) throws Exception{
        Supplier supplier = supplierService.findSupplierById(productDto.id_supplier());
        Product newProduct = new Product();
        newProduct.setProductCategory(productDto.productCategory());
        newProduct.setProductionDate(productDto.productionDate());
        newProduct.setBrand(productDto.brand());
        newProduct.setDescription(productDto.description());
        newProduct.setBarCode(productDto.barCode());
        newProduct.setCostPrice(productDto.costPrice());
        newProduct.setSellingPrice(productDto.sellingPrice());
        newProduct.setQuantity(productDto.quantity());
        newProduct.setSupplier(supplier);

        this.productRepository.save(newProduct);

        StockDto newStockDto = new StockDto(newProduct, newProduct.getQuantity());
        this.stockService.createStock(newStockDto);
        return newProduct;
    }
    public Product updateProduct(ProductDto productDto, Long id) throws Exception{
        Supplier supplier = supplierService.findSupplierById(productDto.id_supplier());
        Product newProduct = findProductById(id);
        newProduct.setProductCategory(productDto.productCategory());
        newProduct.setProductionDate(productDto.productionDate());
        newProduct.setBrand(productDto.brand());
        newProduct.setDescription(productDto.description());
        newProduct.setBarCode(productDto.barCode());
        newProduct.setCostPrice(productDto.costPrice());
        newProduct.setSellingPrice(productDto.sellingPrice());
        newProduct.setQuantity(productDto.quantity());
        newProduct.setSupplier(supplier);

        this.productRepository.save(newProduct);

        StockDto newStockDto = new StockDto(newProduct, newProduct.getQuantity());
        this.stockService.createStock(newStockDto);
        return newProduct;
    }
    public Product findProductById(Long id) throws Exception{
        return this.productRepository.findProductById(id)
                .orElseThrow(()-> new EntityNotFoundException("Produto não encontrado"));

    }
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = this.productRepository.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    public void disableProduct(Long id){
        this.productRepository.disableProduct(id);
    }
}
