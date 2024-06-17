package com.venitmarket.api.dtos;

import com.venitmarket.api.domains.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StockDto(
        @NotNull
        Product product,
        int quantity
) {
}
