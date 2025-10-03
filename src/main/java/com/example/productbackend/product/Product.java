package com.example.productbackend.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //not null + @size min = 1 equals @notblank
    @NotBlank
    private String name;

    private String description;

    @Positive
    private BigDecimal price;

    private String imageUrl;

    @PositiveOrZero
    private int stock_level;

    @CreationTimestamp
    private Instant created_at;

    @CreationTimestamp
    private Instant updated_at;

    private Instant deleted_at;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getStock_level() {
        return stock_level;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }

    public Instant getDeleted_at() {
        return deleted_at;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setStock_level(int stock_level) {
        this.stock_level = stock_level;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }

    public void setDeleted_at(Instant deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return stock_level == product.stock_level && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(imageUrl, product.imageUrl) && Objects.equals(created_at, product.created_at) && Objects.equals(updated_at, product.updated_at) && Objects.equals(deleted_at, product.deleted_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imageUrl, stock_level, created_at, updated_at, deleted_at);
    }
}

