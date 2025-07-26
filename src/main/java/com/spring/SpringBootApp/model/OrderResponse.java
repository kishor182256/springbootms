package com.spring.SpringBootApp.model;


import lombok.Data;

@Data
public class OrderResponse {

    private Long id;
    private User user;
    private  Integer totalAmount;


}
