package com.venimarket.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProductCategoryDto(
        @NotBlank
        String descriptionCategory
) {
}
