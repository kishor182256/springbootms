package com.spring.SpringBootApp.service;

import com.spring.SpringBootApp.dto.CartItem;
import com.spring.SpringBootApp.dto.OrderItemDto;
import com.spring.SpringBootApp.dto.OrderResponse;
import com.spring.SpringBootApp.model.OrderItem;
import com.spring.SpringBootApp.model.Orders;
import com.spring.SpringBootApp.model.Product;
import com.spring.SpringBootApp.model.User;
import com.spring.SpringBootApp.repository.CartItemRepository;
import com.spring.SpringBootApp.repository.OrdersRepository;
import com.spring.SpringBootApp.repository.ProductRepository;
import com.spring.SpringBootApp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Optional<OrderResponse> createOrder(Long userId) {
        List<CartItem> cartItems = null;
        if (cartItems.isEmpty()) {
            return Optional.empty();
        }

        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            return Optional.empty();
        }
        User user = userOpt.get();
        Integer totalPrice = cartItems.stream().map(CartItem::getPrice).reduce(0, Integer::sum);
        Orders order = new Orders();
        order.setUser(user);
        order.setTotalAmount(totalPrice);
        order.setCreatedAt(LocalDateTime.now());
        List<OrderItem> orderItems = cartItems.stream().map(item -> {
            Product product = productRepository.findById(item.getProduct().getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setCartTotal(item.getPrice());
            orderItem.setOrder(order);
            return orderItem;
        }).toList();

        order.setItemList(orderItems);

        Orders savedOrder = ordersRepository.save(order);

        cartItemRepository.deleteAllById(
                cartItems.stream().map(CartItem::getId).toList()
        );

        List<OrderItemDto> itemDTOs = savedOrder.getItemList().stream()
                .map(item -> modelMapper.map(item, OrderItemDto.class))
                .toList();
        OrderResponse responseDTO = new OrderResponse();
        responseDTO.setOrderId(savedOrder.getId());
        responseDTO.setTotalAmount(savedOrder.getTotalAmount());
        responseDTO.setCreatedAt(savedOrder.getCreatedAt());
        responseDTO.setOrdersItems(itemDTOs);
        return Optional.of(responseDTO);
    }
}
