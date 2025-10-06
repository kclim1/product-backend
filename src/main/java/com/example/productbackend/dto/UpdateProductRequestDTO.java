package com.example.productbackend.dto;

import java.math.BigDecimal;

public record UpdateProductRequestDTO(String name, String description, BigDecimal price, String imageUrl,
                                      int stockLevel) {
}
