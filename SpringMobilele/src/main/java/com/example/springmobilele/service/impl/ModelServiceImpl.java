package com.example.springmobilele.service.impl;

import com.example.springmobilele.models.entity.Brand;
import com.example.springmobilele.models.entity.Model;
import com.example.springmobilele.models.entity.enums.Category;
import com.example.springmobilele.repository.ModelRepository;
import com.example.springmobilele.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void initializeModels() {
        if (modelRepository.count() == 0) {

            Model x5 = new Model();
            x5
                    .setCategory(Category.CAR)
                    .setStartYear(1999)
                    .setImageUrl("https://cdn.motor1.com/images/mgl/P3G20A/s3/bmw-x5-m-facelift-rendering-by-kolesa.ru.jpg");


            Model x6 = new Model();
            x6
                    .setCategory(Category.CAR)
                    .setStartYear(2008)
                    .setImageUrl("https://carsalesbase.com/wp-content/uploads/2014/01/BMW_X6-auto-sales-statistics-Europe.jpg");

            modelRepository.saveAll(Set.of(x5, x6));
        }


    }

    @Override
    public boolean isEmpty() {
        return modelRepository.count() == 0;
    }

    @Override
    public List<Model> setBrandToModel(Brand brand) {
        return modelRepository.findAll().stream().map(m->m.setBrand(brand)).collect(Collectors.toList());
    }
}
