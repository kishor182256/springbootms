package com.spring.SpringBootApp.controller;


import com.spring.SpringBootApp.dto.OrderResponse;
import com.spring.SpringBootApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
public class OrderController {

    @Autowired
   private OrderService orderService;

    @GetMapping("/order/{userId}")
    public ResponseEntity<OrderResponse> placeOrder(@PathVariable Long userId) {
        Optional<OrderResponse> orderResponse = orderService.createOrder(userId);
        return orderResponse
                .map(response -> new ResponseEntity<>(response, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


}
