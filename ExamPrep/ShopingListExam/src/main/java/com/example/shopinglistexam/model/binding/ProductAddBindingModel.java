package com.example.shopinglistexam.model.binding;

import com.example.shopinglistexam.model.entity.Category;
import com.example.shopinglistexam.model.entity.enums.CategoryName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {
    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 symbols.")
    private String name;
    @Size(min = 5, message = "Description must be minimum 5 symbols.")
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "Date cannot be in the past.")
    private LocalDateTime neededBefore;
    @Positive(message = "Cannot be negative.")
    @NotNull(message = "Price cannot be empty.")
    private BigDecimal price;
    @NotNull(message = "You must be select category.")
    private String category;

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

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(String category) {
        this.category = category;
        return this;
    }
}
