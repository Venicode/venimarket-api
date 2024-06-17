package com.venitmarket.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerDto(
        @NotNull
        String cpf,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        String phone,
        String email
) {
}
