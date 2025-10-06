package com.example.productbackend.dto;

import java.math.BigDecimal;

public record NewProductRequestDTO(String name, String description, BigDecimal price, String imageUrl , int stockLevel) {}
