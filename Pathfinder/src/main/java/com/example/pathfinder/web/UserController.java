package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.UserLoginBindingModel;
import com.example.pathfinder.model.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.model.view.UserViewModel;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    //Register user

    @GetMapping("/register")
    public String register(Model model) {

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingModel.userRegisterBindingModel",
                            bindingResult);
            return "redirect:register";
        }


        boolean isExistUser = userService.findByUsername(userRegisterBindingModel.getUsername());

        if (isExistUser) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingModel.userRegisterBindingModel",
                            bindingResult);
            return "redirect:/register";
        }

        userService
                .registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    // Login user
    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("isExists", false);

        return "login";
    }

    @PostMapping("/login")
    public String loggedIn(@Valid UserLoginBindingModel userLoginBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);

            return "redirect:login";
        }

        UserServiceModel user = userService
                .findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                        userLoginBindingModel.getPassword());

        if (user == null) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isExists", true);

            return "redirect:login";

        }

        userService.loginUser(user.getId(), user.getUsername());

        return "redirect:/";
    }

    //Logout user

    @GetMapping("/logout")
    private String logout() {
        userService.logout();
        return "redirect:/";
    }

    //User profile info

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, Model model) {

        UserViewModel userViewModel = modelMapper
                .map(userService.findById(id), UserViewModel.class);

        model.addAttribute("user", userViewModel);

        return "profile";
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }
}
