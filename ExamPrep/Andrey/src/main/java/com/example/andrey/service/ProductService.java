package com.example.andrey.service;

import com.example.andrey.model.service.ProductServiceModel;
import com.example.andrey.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {
    ProductServiceModel addProduct(ProductServiceModel productServiceModel);

    List<ProductViewModel> findAllProducts();

    ProductViewModel findProduct(Long id);

    void deleteProduct(Long id);
}
