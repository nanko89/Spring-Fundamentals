package com.example.shopinglistexam.repository;

import com.example.shopinglistexam.model.entity.Product;
import com.example.shopinglistexam.model.entity.enums.CategoryName;
import com.example.shopinglistexam.model.view.ProductViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findByName(String name);

    @Query("SELECT sum(p.price) FROM Product p")
    BigDecimal findTotalProductSum();

    List<Product> findAllByCategory_Name(CategoryName categoryName);
}
