package com.example.heroes.web;

import com.example.heroes.model.binding.UserLoginBindingModel;
import com.example.heroes.model.service.UserServiceModel;
import com.example.heroes.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, HttpSession httpSession, ModelMapper modelMapper) {
        this.userService = userService;
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("isInvalid")){
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

        UserServiceModel userServiceModel = modelMapper
                .map(userLoginBindingModel, UserServiceModel.class);

        UserServiceModel currentUser = userService.login(userServiceModel);

        if (currentUser == null){
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isInvalid", true);

            return "redirect:login";
        }

        httpSession.setAttribute("user", currentUser);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
