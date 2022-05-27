package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.CategoryEnum;

public interface CategoryService {
    void initialised();

    Category findByName(CategoryEnum category);
}
