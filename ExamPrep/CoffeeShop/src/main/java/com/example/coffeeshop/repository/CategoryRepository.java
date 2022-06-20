package com.example.coffeeshop.repository;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryName name);
}