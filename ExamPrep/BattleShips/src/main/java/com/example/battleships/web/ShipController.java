package com.example.battleships.web;

import com.example.battleships.model.binding.ShipAddBindingModel;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.service.ShipService;
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
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;

    private final ModelMapper modelMapper;

    private final HttpSession httpSession;

    public ShipController(ShipService shipService, ModelMapper modelMapper, HttpSession httpSession) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String add(){
        if (httpSession.getAttribute("user") == null){
            return "redirect:/";
        }

        return "ship-add";
    }

    @PostMapping("/add")
    private String confirmAdd(@Valid ShipAddBindingModel shipAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("shipAddBindingModel", shipAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        UserServiceModel currentUser = modelMapper
                .map(httpSession
                        .getAttribute("user"), UserServiceModel.class);

        shipService.addShip(modelMapper.map(shipAddBindingModel, ShipServiceModel.class),currentUser );
        return "redirect:/";
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel(){
        return new ShipAddBindingModel();
    }


}
