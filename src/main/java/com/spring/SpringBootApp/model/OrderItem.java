package com.spring.SpringBootApp.model;


import com.spring.SpringBootApp.dto.ProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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


    public OrderItem(Object o, ProductRequest product, Integer quantity, Orders order) {
    }
}
