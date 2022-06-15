package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ClassificationName;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{


    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true)
    private ClassificationName name;
    @Column(name = "description")
    private String description;

    public Classification() {
    }

    public ClassificationName getName() {
        return name;
    }

    public Classification setName(ClassificationName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
