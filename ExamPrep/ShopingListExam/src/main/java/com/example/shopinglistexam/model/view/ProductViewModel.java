package com.example.shopinglistexam.model.view;

import java.math.BigDecimal;

public class ProductViewModel {
    private String id;
    private String name;
    private BigDecimal price;

    public ProductViewModel() {
    }

    public String getId() {
        return id;
    }

    public ProductViewModel setId(String id) {
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
}
