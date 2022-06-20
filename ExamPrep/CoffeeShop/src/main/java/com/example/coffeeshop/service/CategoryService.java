package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);
}
