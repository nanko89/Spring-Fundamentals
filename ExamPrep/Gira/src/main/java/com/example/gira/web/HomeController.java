package com.example.gira.web;

import com.example.gira.model.entity.enums.Progress;
import com.example.gira.model.web.TaskViewModel;
import com.example.gira.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final HttpSession httpSession;
    private final TaskService taskService;

    public HomeController(HttpSession httpSession, TaskService taskService) {
        this.httpSession = httpSession;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        model.addAttribute("tasks", taskService.findAlView());
        return "home";
    }

    @PostMapping("/")
    public String taskProgress() {


        return "redirect:/";
    }

    @GetMapping("/progress/{id}")
    public String progress(@PathVariable Long id){
        taskService.progress(id);
        return "redirect:/";
    }
}
