package com.venimarket.api.dtos;

import jakarta.validation.constraints.NotNull;

public record OrderDto(
        @NotNull
        Long id_customer,
        @NotNull
        Long id_methodPayment
) {
}
