package com.venimarket.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SupplierDto(
        @NotNull
        String cnpj,
        @NotBlank
        String corporateName,
        @NotBlank
        String tradeName,
        String phone,
        String email
) {
}
