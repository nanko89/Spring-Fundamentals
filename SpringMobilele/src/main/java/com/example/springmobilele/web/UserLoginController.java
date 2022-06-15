package com.example.springmobilele.web;


import com.example.springmobilele.models.binding.UserLoginBindingModel;
import com.example.springmobilele.models.service.UserLoginServiceModel;
import com.example.springmobilele.service.UserService;
import com.example.springmobilele.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserLoginController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(Model model) {

        if (!model.containsAttribute("isInvalid")) {
            model.addAttribute("isInvalid", false);
        }

        return "auth-login";
    }


    @PostMapping("/login")
    public String login(@Valid UserLoginBindingModel userLoginBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginDto", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto",
                            bindingResult);
            return "redirect:login";
        }

        boolean loginSuccessful = userService.login(new UserLoginServiceModel()
                .setUsername(userLoginBindingModel.getUsername())
                .setPassword(userLoginBindingModel.getPassword()));

        LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                userLoginBindingModel.getUsername(),
                loginSuccessful);

        if (!loginSuccessful) {
            redirectAttributes
                    .addFlashAttribute("userLoginDto", userLoginBindingModel)
                    .addFlashAttribute("isInvalid", true);
            return "redirect:login";
        }

        return "redirect:/";
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginDto() {
        return new UserLoginBindingModel();
    }
}
