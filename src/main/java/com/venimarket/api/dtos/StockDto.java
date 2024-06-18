package com.venimarket.api.dtos;

import com.venimarket.api.domains.Product;
import jakarta.validation.constraints.NotNull;

public record StockDto(
        @NotNull
        Product product,
        int quantity
) {
}
