package com.example.shoppinglist.web;

import com.example.shoppinglist.model.binding.UserLoginBindingModel;
import com.example.shoppinglist.model.binding.UserRegisterBindingResult;
import com.example.shoppinglist.model.service.UserServiceModel;
import com.example.shoppinglist.service.UserService;
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
    public String login(Model model){

        if (!model.containsAttribute("isInvalid")){
            model.addAttribute("isInvalid", false);
        }

        return "login";
    }

    @PostMapping("/login")
    public String confirmLogin(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);

            return "redirect:login";
        }

        UserServiceModel serviceModel = modelMapper
                .map(userLoginBindingModel, UserServiceModel.class);


        UserServiceModel currentUser = userService
                .login(serviceModel);

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
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterBindingResult userRegisterBindingResult,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() ||
                !userRegisterBindingResult.getPassword().equals(userRegisterBindingResult.getConfirmPassword())){

            redirectAttributes
                    .addFlashAttribute("userRegisterBindingResult",userRegisterBindingResult)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingResult",
                            bindingResult);
            return "redirect:register";
        }

        UserServiceModel serviceModel = modelMapper.map(userRegisterBindingResult, UserServiceModel.class);

        userService.register(serviceModel);
        return "redirect:login";
    }

    @GetMapping("/logout")
        public String logout(){
        httpSession.invalidate();
        return "redirect:/";
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }

    @ModelAttribute
    public UserRegisterBindingResult userRegisterBindingResult(){
        return new UserRegisterBindingResult();
    }
}
