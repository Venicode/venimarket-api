package com.venimarket.api.dtos;

import com.venimarket.api.domains.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDto(
        @NotBlank
        String description,
        @NotNull
        double costPrice,
        @NotNull
        double sellingPrice,
        @NotNull
        Long id_supplier,
        String productionDate,
        @NotNull
        int quantity,
        @NotBlank
        ProductCategory productCategory,
        @NotNull
        Long barCode,
        String brand
) {}
