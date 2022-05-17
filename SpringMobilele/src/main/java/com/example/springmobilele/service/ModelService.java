package com.example.springmobilele.service;

import com.example.springmobilele.models.entity.Model;


public interface ModelService {

    void initializeModels();

    Model findByName(String modelName);
}
