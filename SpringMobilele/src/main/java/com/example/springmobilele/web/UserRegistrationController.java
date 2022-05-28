package com.example.springmobilele.web;

import com.example.springmobilele.models.binding.UserRegistrationDto;
import com.example.springmobilele.models.service.UserRegistrationServiceModel;
import com.example.springmobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    public UserRegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("userModel")
    public UserRegistrationDto userModel(){
        return new UserRegistrationDto();
    }

    @GetMapping("/users/register")
    public String registerUser() {
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String registration(@Valid UserRegistrationDto userModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("userModel", userModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";

        }

        UserRegistrationServiceModel user = modelMapper
                .map(userModel, UserRegistrationServiceModel.class);

            userService.registerUser(user);

        return "redirect:/";
    }
}