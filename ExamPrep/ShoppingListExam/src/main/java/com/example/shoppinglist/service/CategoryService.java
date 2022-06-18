package com.example.shoppinglist.service;

import com.example.shoppinglist.model.entity.Category;
import com.example.shoppinglist.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategory();

    Category findByName(CategoryName category);
}
