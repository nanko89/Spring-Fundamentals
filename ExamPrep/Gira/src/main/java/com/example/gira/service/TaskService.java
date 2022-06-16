package com.example.gira.service;

import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.model.service.UserServiceModel;

public interface TaskService{
    boolean isFreeName(String name);

    void addTask(TaskServiceModel taskServiceModel, UserServiceModel currentUser);
}
