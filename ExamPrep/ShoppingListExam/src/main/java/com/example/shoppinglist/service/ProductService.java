package com.example.shoppinglist.service;

import com.example.shoppinglist.model.entity.enums.CategoryName;
import com.example.shoppinglist.model.service.ProductServiceModel;
import com.example.shoppinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    boolean isFreeName(String name);

    void addProduct(ProductServiceModel serviceModel);

    List<ProductViewModel> findAllByCategoryName(CategoryName drink);

    BigDecimal findTotalSum();

    void buyProduct(Long id);

    void buyAll();
}
