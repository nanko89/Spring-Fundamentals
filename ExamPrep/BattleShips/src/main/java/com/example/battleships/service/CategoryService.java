package com.example.battleships.service;

import com.example.battleships.model.entity.Category;

public interface CategoryService {
    void initCategories();

    Category findByCategoryEnumName(String category);

}
