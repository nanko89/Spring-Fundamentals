package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.entity.Product;
import com.example.shoppinglist.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNameIgnoreCase(String name);

    List<Product> findAllByCategory_Name(CategoryName categoryName);

    @Query("SELECT SUM(p.price) FROM Product p")
    BigDecimal findTotalProductSum();
}