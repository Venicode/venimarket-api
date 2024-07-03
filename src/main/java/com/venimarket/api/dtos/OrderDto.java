package com.venimarket.api.dtos;

import jakarta.validation.constraints.NotNull;

public record OrderDto(
        Long id_customer,
        @NotNull
        Long id_methodPayment
) {
}
