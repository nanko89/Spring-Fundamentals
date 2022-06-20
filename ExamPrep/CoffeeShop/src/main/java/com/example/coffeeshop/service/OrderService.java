package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Order;
import com.example.coffeeshop.model.service.OrderServiceModel;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel, UserServiceModel user);

    Integer sumTotalTimeToOrder();

    List<OrderViewModel> getAllOrders();

    void readyOrder(Long id);


}
