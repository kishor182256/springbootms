package com.spring.SpringBootApp.repository;

import com.spring.SpringBootApp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface OrdersRepository  extends JpaRepository<Orders,Long> {
}
