package com.example.productbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record NewProductRequestDTO(@NotBlank String name, String description, @Positive BigDecimal price, String imageUrl ,@PositiveOrZero int stockLevel) {}
