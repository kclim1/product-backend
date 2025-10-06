package com.example.productbackend.controller;

import com.example.productbackend.dto.NewProductRequestDTO;
import com.example.productbackend.dto.ProductResponseDTO;
import com.example.productbackend.dto.UpdateProductRequestDTO;
import com.example.productbackend.product.Product;
import com.example.productbackend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDTO> findAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable UUID id) {
//        use service.findById and store response in variable.
        ProductResponseDTO fetchedProduct = productService.fetchProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fetchedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable UUID id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody NewProductRequestDTO request) {
//        receives json object and passes it to service where its mapped to request dto
        Product addedProduct = productService.addProduct(request);
//        processes the request and then passes the response to response dto
        ProductResponseDTO response = new ProductResponseDTO("product added succesfully!!", addedProduct);
//        returns the response as part of response entity.
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProductById(@PathVariable UUID id, @RequestBody UpdateProductRequestDTO updatedProduct) {
        ProductResponseDTO update = productService.updateProductById(id, updatedProduct);
        ProductResponseDTO updatedSuccessfully = new ProductResponseDTO("updated successfully",update.product());
        return ResponseEntity.ok(updatedSuccessfully);
    }

}
