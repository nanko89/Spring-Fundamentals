package com.example.springmobilele.web;

import com.example.springmobilele.models.binding.UserRegistrationDto;
import com.example.springmobilele.models.entity.User;
import com.example.springmobilele.models.service.UserRegistrationServiceModel;
import com.example.springmobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserRegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/users/register")
    public String registerUser() {
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String registration(UserRegistrationDto registrationUser) {

        UserRegistrationServiceModel user = modelMapper
                .map(registrationUser, UserRegistrationServiceModel.class);

        userService.registerUser(user);
        return "redirect:/";
    }
}
