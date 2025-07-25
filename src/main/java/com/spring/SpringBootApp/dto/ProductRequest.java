package com.spring.SpringBootApp.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductRequest {

    private String productName;
    private String description;
    private  Integer stockQuantity;
    private String Category;
    private Integer price;
    private String imageUrl;
    private Boolean isActive = true;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
