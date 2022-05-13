package com.example.springmobilele.service.impl;

import com.example.springmobilele.models.entity.Brand;
;
import com.example.springmobilele.repository.BrandRepository;
import com.example.springmobilele.service.BrandService;
import com.example.springmobilele.service.ModelService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelService modelService;

    public BrandServiceImpl(BrandRepository brandRepository, ModelService modelService) {
        this.brandRepository = brandRepository;
        this.modelService = modelService;
    }


    @Override
    public void initializeBrandWithModels() {
        if (brandRepository.count() == 0) {
            Brand bmw = new Brand();
            bmw.setName("BMW").setCreated(LocalDateTime.now());

            if(modelService.isEmpty()){
                modelService.initializeModels();
            }
            bmw.setModels(modelService.setBrandToModel(bmw));
            brandRepository.save(bmw);
        }
    }
}
