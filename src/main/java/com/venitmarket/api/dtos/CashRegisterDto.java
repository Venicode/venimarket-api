package com.venitmarket.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CashRegisterDto(
        double balance
) {
}
