package com.example.shopinglistexam.service;

import com.example.shopinglistexam.model.entity.enums.CategoryName;
import com.example.shopinglistexam.model.service.ProductServiceModel;
import com.example.shopinglistexam.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void addProduct(ProductServiceModel productServiceModel);

    ProductServiceModel findByName(String name);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductByCategoryName(CategoryName categoryName);

    void buyProduct(String id);

    void buyAllProduct();

}
