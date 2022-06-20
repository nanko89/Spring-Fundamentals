package com.example.coffeeshop.model.entity;

import com.example.coffeeshop.model.entity.enums.CategoryName;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoryName name;
    @Column(name = "needed_time", nullable = false)
    private Integer neededTime;

    public Category() {
    }

    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
