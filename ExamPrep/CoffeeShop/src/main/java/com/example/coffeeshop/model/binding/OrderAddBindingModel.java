package com.example.coffeeshop.model.binding;

import com.example.coffeeshop.model.entity.enums.CategoryName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;
    @Positive
    @NotNull
    private BigDecimal price;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @PastOrPresent
    private LocalDateTime orderTime;
    @NotNull
    private CategoryName category;
    @NotBlank
    @Size(min = 5)
    private String description;

    public OrderAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public OrderAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddBindingModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public OrderAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
