package com.venimarket.api.dtos.exceptions;

import org.springframework.validation.FieldError;

public record FieldsErrorsException(String field, String message) {
    public FieldsErrorsException(FieldError fieldError){
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
