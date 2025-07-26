package com.spring.SpringBootApp.dto;

import lombok.Data;

@Data
public class OrderItemDto {

    private Long Id;
    private Long productId;
    private Integer quantity;
    private Integer price;


}
