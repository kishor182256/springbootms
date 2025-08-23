package com.spring.SpringBootApp.controller;

import com.spring.SpringBootApp.dto.CartItem;
import com.spring.SpringBootApp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class Cart {

    @Autowired
    private CartService cartService;

    @PostMapping("/add-to-cart")
    public ResponseEntity<Void> addToCart(@RequestBody CartItem cartItemRequest) {
        cartService.addItemToCart(cartItemRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<List<com.spring.SpringBootApp.dto.CartItem>> getCartItems(@PathVariable Long userId, Principal principal) {
        List<com.spring.SpringBootApp.dto.CartItem> items = cartService.getCartItemsByUserId(userId,principal);
        return ResponseEntity.ok(items);
    }

}