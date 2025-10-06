package com.example.productbackend.service;

import com.example.productbackend.dto.NewProductRequestDTO;
import com.example.productbackend.dto.ProductResponseDTO;
import com.example.productbackend.dto.UpdateProductRequestDTO;
import com.example.productbackend.product.Product;
import com.example.productbackend.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> new ProductResponseDTO("", product)).toList();
    }

    public ProductResponseDTO fetchProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product with id not found"));
        return new ProductResponseDTO("item found",product);
    }

    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }

    public Product addProduct(NewProductRequestDTO dto) {
        Product newProduct = new Product(dto.name(), dto.description(), dto.price(), dto.imageUrl(), dto.stockLevel());
        productRepository.save(newProduct);
        return newProduct;
    }
    public ProductResponseDTO updateProductById(UUID id , UpdateProductRequestDTO dto){
        Product existingProduct = productRepository.findById(id).orElseThrow(()->new ResponseStatusException((HttpStatus.NOT_FOUND),"product with id not found"));

        existingProduct.setName(dto.name());
        existingProduct.setDescription(dto.description());
        existingProduct.setPrice(dto.price());
        existingProduct.setImageUrl(dto.imageUrl());
        existingProduct.setStock_level(dto.stockLevel());
        Product updated = productRepository.save(existingProduct);
        return new ProductResponseDTO("product updated" , updated);
    }
}
