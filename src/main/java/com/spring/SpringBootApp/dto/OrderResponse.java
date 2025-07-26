package com.spring.SpringBootApp.dto;

import com.spring.SpringBootApp.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {

    private  Long orderId;
    private Integer totalAmount;
    private OrderStatus orderStatus;
    private List<OrderItemDto> ordersItems;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
