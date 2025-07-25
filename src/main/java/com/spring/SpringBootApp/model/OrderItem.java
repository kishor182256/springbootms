package com.spring.SpringBootApp.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderItem {

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private  Integer cartTotal;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private  Orders order;


}
