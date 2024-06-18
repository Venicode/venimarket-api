package com.venimarket.api.dtos;

import jakarta.validation.constraints.NotNull;

public record SellDto(
        Long id_customer,
        @NotNull
        Long id_product,
        @NotNull
        Long id_methodPayment,
        @NotNull
        double amount,
        @NotNull
        int quantity
) {
}
