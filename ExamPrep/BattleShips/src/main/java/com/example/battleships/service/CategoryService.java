package com.example.battleships.service;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryEnum category);
}
