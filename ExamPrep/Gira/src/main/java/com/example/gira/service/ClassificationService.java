package com.example.gira.service;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.enums.ClassificationName;

public interface ClassificationService {
    void initClassification();

    Classification findByClassificationName(ClassificationName name);
}
