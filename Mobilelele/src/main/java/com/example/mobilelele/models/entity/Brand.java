package com.example.mobilelele.models.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    private String name;

    @OneToMany
    private Set<Model> models;

    public Brand() {
    }

    public Set<Model> getModels() {
        return models;
    }

    public Brand setModels(Set<Model> models) {
        this.models = models;
        return this;
    }

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }
}
