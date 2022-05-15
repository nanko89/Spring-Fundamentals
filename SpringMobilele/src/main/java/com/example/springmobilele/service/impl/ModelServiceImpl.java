package com.example.springmobilele.service.impl;

import com.example.springmobilele.models.entity.Brand;
import com.example.springmobilele.models.entity.Model;
import com.example.springmobilele.models.entity.enums.Category;
import com.example.springmobilele.repository.ModelRepository;
import com.example.springmobilele.service.BrandService;
import com.example.springmobilele.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public ModelServiceImpl(ModelRepository modelRepository, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }

    @Override
    public void initializeModels() {
        if (modelRepository.count() == 0) {

            Model x5 = new Model();
            x5
                    .setName("X5")
                    .setCategory(Category.CAR)
                    .setStartYear(1999)
                    .setImageUrl("https://cdn.motor1.com/images/mgl/P3G20A/s3/bmw-x5-m-facelift-rendering-by-kolesa.ru.jpg")
                    .setBrand(brandService.getBrands().get(0));


            Model x6 = new Model();
            x6
                    .setName("X6")
                    .setCategory(Category.CAR)
                    .setStartYear(2008)
                    .setImageUrl("https://carsalesbase.com/wp-content/uploads/2014/01/BMW_X6-auto-sales-statistics-Europe.jpg")
                    .setBrand(brandService.getBrands().get(0));

            modelRepository.saveAll(Set.of(x5, x6));
        }
    }
}
