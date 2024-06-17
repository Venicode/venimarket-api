package com.venitmarket.api.dtos;

import com.venitmarket.api.domains.Customer;
import com.venitmarket.api.domains.MethodPayment;
import com.venitmarket.api.domains.Product;
import jakarta.validation.constraints.NotNull;

public record SellDto(
        @NotNull
        Customer customer,
        @NotNull
        Product product,
        @NotNull
        MethodPayment methodPayment,
        @NotNull
        double amount,
        @NotNull
        int quantity
) {
}
