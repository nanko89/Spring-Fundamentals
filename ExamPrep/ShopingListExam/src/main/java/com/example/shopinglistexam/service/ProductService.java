package com.example.shopinglistexam.service;

import com.example.shopinglistexam.model.service.ProductServiceModel;

public interface ProductService {

    void addProduct(ProductServiceModel productServiceModel);

    ProductServiceModel findByName(String name);
}
