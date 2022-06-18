package com.example.shoppinglist.model.entity;

import com.example.shoppinglist.model.entity.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoryName name;
    @Column(name = "decscription")
    private String description;

    public Category() {
    }

    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
