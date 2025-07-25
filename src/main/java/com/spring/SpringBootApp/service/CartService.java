package com.spring.SpringBootApp.service;

import com.spring.SpringBootApp.model.CartItem;
import com.spring.SpringBootApp.model.Product;
import com.spring.SpringBootApp.model.User;
import com.spring.SpringBootApp.repository.CartItemRepository;
import com.spring.SpringBootApp.repository.ProductRepository;
import com.spring.SpringBootApp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ModelMapper modelMapper;

    public void addItemToCart(com.spring.SpringBootApp.dto.CartItem cartItemDto) {
        Long userId = cartItemDto.getUser().getUserId();
        Long productId = cartItemDto.getProduct().getProductId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + productId));

        CartItem cartItem = new CartItem();
        cartItem.setUser(user);
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItem.setPrice(cartItemDto.getPrice() != null ? cartItemDto.getPrice() : product.getPrice());

        cartItemRepository.save(cartItem);
    }




    public List<com.spring.SpringBootApp.dto.CartItem> getCartItemsByUserId(Long userId) {
        List<com.spring.SpringBootApp.dto.CartItem> dtoList = cartItemRepository.findByUserId(userId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        Collections.reverse(dtoList);
        return dtoList;
    }

    private com.spring.SpringBootApp.dto.CartItem convertToDto(CartItem cartItem) {
        com.spring.SpringBootApp.dto.CartItem dto = modelMapper.map(cartItem, com.spring.SpringBootApp.dto.CartItem.class);
        dto.setUser(modelMapper.map(cartItem.getUser(), com.spring.SpringBootApp.dto.UserRequest.class));
        dto.setProduct(modelMapper.map(cartItem.getProduct(), com.spring.SpringBootApp.dto.ProductRequest.class));

        return dto;
    }



}
