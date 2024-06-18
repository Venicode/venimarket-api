package com.venimarket.api.services;

import com.venimarket.api.domains.Product;
import com.venimarket.api.domains.Stock;
import com.venimarket.api.dtos.StockDto;
import com.venimarket.api.repositories.ProductRepository;
import com.venimarket.api.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductRepository productRepository;
    public Stock createStock(StockDto stockDto){
        Stock newStock = new Stock();
        newStock.setProduct(stockDto.product());
        newStock.setQuantity(stockDto.product().getQuantity());

        this.stockRepository.save(newStock);
        return newStock;
    }
    public void updateStock(int quantity, Product product) throws Exception {
        product.setQuantity(quantity);
        this.stockRepository.updateQuantity(quantity, product);
    }
}
