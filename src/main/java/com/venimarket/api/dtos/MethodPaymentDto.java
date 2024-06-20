package com.venimarket.api.dtos;

import jakarta.validation.constraints.NotNull;

public record MethodPaymentDto(
        @NotNull
        String typesPayments
) {
}
