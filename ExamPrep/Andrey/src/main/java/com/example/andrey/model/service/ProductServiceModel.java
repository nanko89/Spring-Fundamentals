package com.example.andrey.model.service;

import com.example.andrey.model.entity.enums.Category;
import com.example.andrey.model.entity.enums.Sex;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProductServiceModel {

    private Long id;
    private String name;

    private String description;

    private Category category;

    private Sex sex;

    private BigDecimal price;

    public ProductServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ProductServiceModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public ProductServiceModel setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
