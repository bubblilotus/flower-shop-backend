package com.flowershop.flowershop.service;

import com.flowershop.flowershop.dao.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
}
