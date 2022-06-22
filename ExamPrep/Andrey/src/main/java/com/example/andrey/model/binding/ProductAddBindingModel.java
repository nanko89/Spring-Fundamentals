package com.example.andrey.model.binding;

import com.example.andrey.model.entity.enums.Category;
import com.example.andrey.model.entity.enums.Sex;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProductAddBindingModel {
    @NotBlank(message = "Price must not be empty")
    private String name;

    private String description;

    @NotNull(message = "Category must not be empty")
    private Category category;

    @NotNull(message = "Sex must not be empty")
    private Sex sex;

    @NotNull(message = "Price must not be empty")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    public ProductAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public ProductAddBindingModel setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
