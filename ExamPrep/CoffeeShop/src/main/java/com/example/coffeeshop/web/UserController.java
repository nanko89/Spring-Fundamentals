package com.example.coffeeshop.web;

import com.example.coffeeshop.model.binding.UserLoginBindingModel;
import com.example.coffeeshop.model.binding.UserRegisterBindingModel;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public UserController(UserService userService, ModelMapper modelMapper, HttpSession httpSession) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("isInvalid")) {
            model.addAttribute("isInvalid", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String confirmLogin(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService
                .loginUser(modelMapper.map(userLoginBindingModel, UserServiceModel.class));
        if (userServiceModel == null) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isInvalid", true);
            return "redirect:login";
        }

        httpSession.setAttribute("user", userServiceModel);

        return "redirect:/";

    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);

            return "redirect:register";
        }

        UserServiceModel userServiceModel = this.userService
                .registerUser(modelMapper
                        .map(userRegisterBindingModel, UserServiceModel.class));


        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout() {
        httpSession.invalidate();
        return "redirect:/";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }
}
