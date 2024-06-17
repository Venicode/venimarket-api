package com.venitmarket.api.dtos;

import com.venitmarket.api.domains.PaymentsTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MethodPaymentDto(
        @NotNull
        PaymentsTypes typesPayments
) {
}
