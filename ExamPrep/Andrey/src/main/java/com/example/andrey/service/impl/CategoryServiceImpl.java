package com.example.andrey.service.impl;

import com.example.andrey.model.entity.Category;
import com.example.andrey.model.entity.enums.CategoryName;
import com.example.andrey.repository.CategoryRepository;
import com.example.andrey.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategory() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category
                                .setName(categoryName)
                                .setDescription("Description for " + categoryName.name().toLowerCase());

                        categoryRepository.save(category);
                    });
        }
    }
}
