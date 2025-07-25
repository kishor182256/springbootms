package com.spring.SpringBootApp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartItem {
    private Long id;
    private UserRequest user;
    private ProductRequest product;
    private Integer price;
    private Integer quantity;
    private LocalDateTime orderDate;
    private LocalDateTime updatedAt;
}
