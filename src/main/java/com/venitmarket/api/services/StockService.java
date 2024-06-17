package com.venitmarket.api.services;

import com.venitmarket.api.domains.Product;
import com.venitmarket.api.domains.Stock;
import com.venitmarket.api.dtos.StockDto;
import com.venitmarket.api.repositories.ProductRepository;
import com.venitmarket.api.repositories.StockRepository;
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
    public void updateStock(int quantity, Long idProduto) throws Exception {
        Product product = this.productRepository.findProductById(idProduto)
                .orElseThrow(()-> new Exception("Produto não encontrado"));
        product.setQuantity(quantity);
        this.stockRepository.updateQuantity(product.getId(), quantity);
    }
}
