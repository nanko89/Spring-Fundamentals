package com.example.springmobilele.service.impl;

import com.example.springmobilele.models.entity.Brand;
;
import com.example.springmobilele.repository.BrandRepository;
import com.example.springmobilele.service.BrandService;
import com.example.springmobilele.service.ModelService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;


    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            Brand bmw = new Brand();
            bmw.setName("BMW").setCreated(LocalDateTime.now());
            brandRepository.save(bmw);
        }
    }

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
