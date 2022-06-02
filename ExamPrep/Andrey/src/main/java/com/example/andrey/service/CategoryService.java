package com.example.andrey.service;

import com.example.andrey.model.entity.Category;
import com.example.andrey.model.entity.enums.CategoryName;

public interface CategoryService {

    void initCategory();

    Category findByCategoryName(CategoryName category);

}
