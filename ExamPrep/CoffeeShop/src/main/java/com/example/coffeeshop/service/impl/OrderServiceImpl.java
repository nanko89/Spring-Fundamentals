package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.entity.Order;
import com.example.coffeeshop.model.service.OrderServiceModel;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.repository.OrderRepository;
import com.example.coffeeshop.service.CategoryService;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    public OrderServiceImpl(OrderRepository orderRepository, CategoryService categoryService, UserService userService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel, UserServiceModel user) {
        Order order = modelMapper
                .map(orderServiceModel, Order.class);
        order
                .setCategory(categoryService
                        .findByName(orderServiceModel.getCategoryName()))
                .setEmployee(userService
                        .findByUsername(user.getUsername()));

        orderRepository.save(order);
    }

    @Override
    public Integer sumTotalTimeToOrder() {
        return orderRepository.findAll()
                .stream()
                .mapToInt(value -> value.getCategory().getNeededTime())
                .sum();
    }

    @Override
    public List<Order> getAllOrders() {
        return this.orderRepository
                .findAll()
                .stream().sorted(Comparator.comparing(Order::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
