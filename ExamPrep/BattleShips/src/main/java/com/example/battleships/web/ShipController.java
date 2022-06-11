package com.example.battleships.web;

import com.example.battleships.model.binding.ShipAddBindingModel;
import com.example.battleships.model.entity.Category;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.service.CategoryService;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
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
@RequestMapping("/ship")
public class ShipController {

    private final ShipService shipService;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    private final HttpSession httpSession;

    public ShipController(ShipService shipService, CategoryService categoryService, UserService userService, ModelMapper modelMapper, HttpSession httpSession) {
        this.shipService = shipService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String addShip() {
        return "ship-add";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",
                            bindingResult);
            return "redirect:/add";
        }

        ShipServiceModel serviceModel = modelMapper
                .map(shipAddBindingModel, ShipServiceModel.class);

        Category category = categoryService
                .findByCategoryEnumName(shipAddBindingModel.getCategory());

        UserServiceModel currentUser = modelMapper
                .map(httpSession.getAttribute("user"), UserServiceModel.class);

        serviceModel.setCategory(category);

        shipService.addShips(serviceModel, currentUser);
        return "redirect:/";
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel(){
        return new ShipAddBindingModel();
    }
}
