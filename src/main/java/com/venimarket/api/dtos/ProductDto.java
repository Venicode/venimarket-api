package com.venimarket.api.dtos;

import com.venimarket.api.domains.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ProductDto(
        @NotBlank
        String description,
        @NotNull
        double costPrice,
        @NotNull
        double sellingPrice,
        @NotNull
        Long id_supplier,
        LocalDate productionDate,
        @NotNull
        int quantity,
        @NotNull
        ProductCategory productCategory,
        @NotNull
        Long barCode,
        String brand
) {}
