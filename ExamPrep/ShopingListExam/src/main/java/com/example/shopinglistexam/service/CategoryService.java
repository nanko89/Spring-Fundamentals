package com.example.shopinglistexam.service;

import com.example.shopinglistexam.model.entity.Category;
import com.example.shopinglistexam.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategory();

    Category findByName(CategoryName categoryName);
}
