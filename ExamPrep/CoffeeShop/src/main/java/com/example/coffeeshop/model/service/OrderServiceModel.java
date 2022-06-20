package com.example.coffeeshop.model.service;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.enums.CategoryName;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {

    private Long id;
    private String description;
    private String name;
    private LocalDateTime orderTime;
    private BigDecimal price;
    private CategoryName categoryName;

    public OrderServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public OrderServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderServiceModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public OrderServiceModel setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
        return this;
    }
}
