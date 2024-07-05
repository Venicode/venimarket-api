package com.venimarket.api.dtos;

import jakarta.validation.constraints.NotNull;

public record ItemOrderDto(
        @NotNull
        Long id_product,
        @NotNull
        Long id_order,
        @NotNull
        double amount,
        @NotNull
        int quantity,
        double discount
) {
}
