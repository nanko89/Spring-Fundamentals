package com.example.gira.model.binding;

import com.example.gira.model.entity.enums.ClassificationName;
import com.example.gira.model.validation.UniqueName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class TaskAddBindingModel {
    @NotBlank
    @Size(min = 3, max = 20)
    @UniqueName
    private String name;
    @NotBlank
    @Size(min = 5)
    private String description;
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dueDate;
    @NotNull
    private ClassificationName classification;

    @NotNull
    private String email;

    public TaskAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public TaskAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationName getClassification() {
        return classification;
    }

    public TaskAddBindingModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TaskAddBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
