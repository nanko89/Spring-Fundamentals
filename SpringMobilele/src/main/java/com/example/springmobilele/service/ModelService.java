package com.example.springmobilele.service;

import com.example.springmobilele.models.entity.Model;

import java.util.List;


public interface ModelService {

    void initializeModels();

    Model findByName(String modelName);

    List<Model> getModels();
}
