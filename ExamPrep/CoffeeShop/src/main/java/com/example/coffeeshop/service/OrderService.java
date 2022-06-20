package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Order;
import com.example.coffeeshop.model.service.OrderServiceModel;
import com.example.coffeeshop.model.service.UserServiceModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel, UserServiceModel user);

    Integer sumTotalTimeToOrder();

    List<Order> getAllOrders();

    void readyOrder(Long id);


}
