package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.enums.CategoryName;
import com.example.coffeeshop.repository.CategoryRepository;
import com.example.coffeeshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName)
                                .setNeededTime(categoryName.getTime());

                        this.categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByName(CategoryName categoryName) {
        return categoryRepository
                .findByName(categoryName);
    }
}
