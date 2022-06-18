package com.example.shoppinglist.init;

import com.example.shoppinglist.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryBaseInit implements CommandLineRunner {
    private final CategoryService categoryService;

    public CategoryBaseInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategory();
    }
}
