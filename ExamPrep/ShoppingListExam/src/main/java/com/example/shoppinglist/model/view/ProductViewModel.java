package com.example.shoppinglist.model.view;

import com.example.shoppinglist.model.entity.enums.CategoryName;

import java.math.BigDecimal;

public class ProductViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private CategoryName category;

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

    public BigDecimal getPrice() {
        return price;
    }

    public ProductViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public ProductViewModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
