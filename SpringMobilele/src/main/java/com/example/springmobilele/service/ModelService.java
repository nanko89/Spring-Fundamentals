package com.example.springmobilele.service;

import com.example.springmobilele.models.entity.Brand;
import com.example.springmobilele.models.entity.Model;

import java.util.List;

public interface ModelService {

    void initializeModels();

    boolean isEmpty();

    List<Model> setBrandToModel(Brand brand);

}
