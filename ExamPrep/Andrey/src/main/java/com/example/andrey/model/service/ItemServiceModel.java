package com.example.andrey.model.service;

import com.example.andrey.model.entity.enums.CategoryName;
import com.example.andrey.model.entity.enums.Gender;

import java.math.BigDecimal;

public class ItemServiceModel {

    private Long id;
    private String name;
    private String description;
    private CategoryName category;
    private Gender gender;
    private BigDecimal price;

    public ItemServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ItemServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public ItemServiceModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public ItemServiceModel setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
