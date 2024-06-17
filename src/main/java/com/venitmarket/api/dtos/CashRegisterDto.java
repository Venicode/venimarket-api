package com.venitmarket.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CashRegisterDto(
        LocalDateTime date,
        double balance
) {
}
