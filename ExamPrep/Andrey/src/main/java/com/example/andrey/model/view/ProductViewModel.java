package com.example.andrey.model.view;

import java.math.BigDecimal;

public class ProductViewModel {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String sex;
    private BigDecimal price;

    public ProductViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductViewModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public ProductViewModel setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
