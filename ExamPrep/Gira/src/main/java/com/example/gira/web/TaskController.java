package com.example.gira.web;

import com.example.gira.model.binding.TaskAddBindingModel;
import com.example.gira.model.entity.enums.Progress;
import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.model.service.UserServiceModel;
import com.example.gira.service.TaskService;
import com.example.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public TaskController(TaskService taskService, UserService userService, ModelMapper modelMapper, HttpSession httpSession) {
        this.taskService = taskService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String add() {
        return "add-task";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("taskAddBindingModel", taskAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        TaskServiceModel taskServiceModel = modelMapper
                .map(taskAddBindingModel, TaskServiceModel.class);

        UserServiceModel currentUser = modelMapper
                .map(httpSession.getAttribute("user"), UserServiceModel.class);


        taskServiceModel
                .setProgress(Progress.OPEN);

        taskService
                .addTask(taskServiceModel, currentUser);

        return "redirect:/";
    }

    @ModelAttribute
    public TaskAddBindingModel taskAddBindingModel(){
        return new TaskAddBindingModel();
    }
}
