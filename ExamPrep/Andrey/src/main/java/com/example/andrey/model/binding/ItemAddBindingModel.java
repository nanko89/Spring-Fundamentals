package com.example.andrey.model.binding;

import com.example.andrey.model.entity.enums.CategoryName;
import com.example.andrey.model.entity.enums.Gender;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    @NotBlank
    @Size(min = 2, message = "Name must be more then two characters")
    private String name;
    @NotBlank
    @Size(min = 3, message = "Description must be more then three characters")
    private String description;
    @NotNull(message = "Enter valid category name")
    private CategoryName category;
    @NotNull(message = "Enter valid gender")
    private Gender gender;
    @NotNull
    @Positive(message = "Enter valid price")
    private BigDecimal price;

    public ItemAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
