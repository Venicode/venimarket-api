package com.venimarket.api.dtos;

import com.venimarket.api.domains.PaymentsTypes;
import jakarta.validation.constraints.NotNull;

public record MethodPaymentDto(
        @NotNull
        PaymentsTypes typesPayments
) {
}
