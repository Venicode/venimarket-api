package com.venitmarket.api.dtos;

import com.venitmarket.api.domains.Customer;
import com.venitmarket.api.domains.MethodPayment;
import com.venitmarket.api.domains.Product;
import jakarta.validation.constraints.NotNull;

public record SellDto(
        Long id_customer,
        @NotNull
        Long id_product,
        @NotNull
        Long id_methodPayment,
        @NotNull
        double amount,
        @NotNull
        int quantity
) {
}
