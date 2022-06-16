package com.example.gira.service.impl;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.enums.ClassificationName;
import com.example.gira.repository.ClassificationRepository;
import com.example.gira.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initClassification() {
        if (classificationRepository.count() == 0) {
            Arrays.stream(ClassificationName.values())
                    .forEach(classificationName -> {
                        Classification classification = new Classification();
                        classification.setName(classificationName)
                                .setDescription("Description for " + classificationName.name().toLowerCase());

                        classificationRepository.save(classification);
                    });
        }
    }

    @Override
    public Classification findByClassificationName(ClassificationName name) {
        return classificationRepository
                .findByName(name)
                .orElse(null);
    }
}
