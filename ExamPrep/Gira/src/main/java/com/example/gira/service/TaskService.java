package com.example.gira.service;

import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.model.service.UserServiceModel;
import com.example.gira.model.web.TaskViewModel;

import java.util.List;

public interface TaskService{
    boolean isFreeName(String name);

    void addTask(TaskServiceModel taskServiceModel, UserServiceModel currentUser);

    List<TaskViewModel> findAlView();

    void progress(Long id);
}
