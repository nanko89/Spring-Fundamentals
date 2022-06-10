package com.example.battleships.model.entity;

import com.example.battleships.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

   @Enumerated(EnumType.STRING)
   @Column(name = "name", nullable = false, unique = true)
   private CategoryEnum name;
   @Column(name = "description", columnDefinition = "TEXT")
   private String description;

    public Category() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
