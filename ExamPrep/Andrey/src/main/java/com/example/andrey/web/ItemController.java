package com.example.andrey.web;

import com.example.andrey.model.binding.ItemAddBindingModel;
import com.example.andrey.model.entity.enums.CategoryName;
import com.example.andrey.model.entity.enums.Gender;
import com.example.andrey.model.service.ItemServiceModel;
import com.example.andrey.model.view.ItemViewModel;
import com.example.andrey.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("existItem", false)
                .addAttribute("gender", Gender.values())
                .addAttribute("categories", CategoryName.values());


        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        boolean existItem = itemService
                .findByName(itemAddBindingModel.getName());

        if (existItem) {

            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel)
                    .addFlashAttribute("existItem", true);

            return "redirect:add";
        }


        itemService
                .addItem(modelMapper.map(itemAddBindingModel, ItemServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String detailsItem(@PathVariable Long id, Model model){

        ItemViewModel itemViewModel = itemService.findById(id);
        model.addAttribute("item", itemViewModel );

        return "details-item";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        itemService.deleteItemById(id);
        return "redirect:/";
    }

    @ModelAttribute
    public ItemAddBindingModel itemAddBindingModel(){
        return new ItemAddBindingModel();
    }

}
