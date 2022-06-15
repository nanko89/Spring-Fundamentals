package com.example.springmobilele.service;

import com.example.springmobilele.models.entity.Brand;
import com.example.springmobilele.models.entity.Model;

import java.util.List;

public interface BrandService {

    void initializeBrand();

    List<Brand> getBrands();

    List<Model> getAllModels(Long id);
}
