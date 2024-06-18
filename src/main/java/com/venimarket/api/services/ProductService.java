package com.venimarket.api.services;

import com.venimarket.api.domains.Product;
import com.venimarket.api.domains.Supplier;
import com.venimarket.api.dtos.ProductDto;
import com.venimarket.api.dtos.StockDto;
import com.venimarket.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Product findProductById(Long id) throws Exception{
        return this.productRepository.findProductById(id)
                .orElseThrow(()-> new Exception("Produto não encontrado"));

    }
}
