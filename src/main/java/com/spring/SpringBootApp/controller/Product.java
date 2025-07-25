package com.spring.SpringBootApp.controller;

import com.spring.SpringBootApp.dto.ProductRequest;
import com.spring.SpringBootApp.dto.ProductResponse;
import com.spring.SpringBootApp.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Product {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse response = productService.createProduct(productRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequest productRequest) {

        ProductResponse response = productService.updateProduct(id, productRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
