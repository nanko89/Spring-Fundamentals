package com.example.gira.service.impl;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.Task;
import com.example.gira.model.entity.User;
import com.example.gira.model.entity.enums.Progress;
import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.model.service.UserServiceModel;
import com.example.gira.model.web.TaskViewModel;
import com.example.gira.repository.TaskRepository;
import com.example.gira.service.ClassificationService;
import com.example.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    private final ClassificationService classificationService;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ClassificationService classificationService, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.classificationService = classificationService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isFreeName(String name) {
        return taskRepository
                .findByNameIgnoreCase(name)
                .isEmpty();
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel, UserServiceModel currentUser) {
        User user = modelMapper
                .map(currentUser, User.class);

        Task task = modelMapper
                .map(taskServiceModel, Task.class);

        task.setUser(user);

        Classification classification = classificationService
                .findByClassificationName(taskServiceModel.getClassification().getName());

        task.setClassification(classification);

        taskRepository.save(task);
    }

    @Override
    public List<TaskViewModel> findAlView() {
        return taskRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task, TaskViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void progress(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        String progressName = task.get().getProgress().name();
        switch (progressName) {
            case "OPEN" -> {
                task.get().setProgress(Progress.IN_PROGRESS);
                taskRepository.save(task.get());
            }
            case "IN_PROGRESS" -> {
                task.get().setProgress(Progress.COMPLETED);
                taskRepository.save(task.get());
            }
            case "COMPLETED" -> taskRepository.deleteById(id);
        }
    }
}
