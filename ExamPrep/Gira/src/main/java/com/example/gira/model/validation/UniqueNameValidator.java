package com.example.gira.model.validation;

import com.example.gira.service.TaskService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private final TaskService taskService;

    public UniqueNameValidator(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {

        if (name == null){
            return true;
        }
        return taskService.isFreeName(name);
    }
}
