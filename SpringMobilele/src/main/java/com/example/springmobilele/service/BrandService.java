package com.example.springmobilele.service;

import com.example.springmobilele.models.entity.Brand;

import java.util.List;

public interface BrandService {

    void initializeBrand();

    List<Brand> getBrands();
}
