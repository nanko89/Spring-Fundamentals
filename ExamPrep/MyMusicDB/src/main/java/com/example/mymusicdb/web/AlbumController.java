package com.example.mymusicdb.web;

import com.example.mymusicdb.model.binding.AlbumAddBindingModel;
import com.example.mymusicdb.model.service.AlbumServiceModel;
import com.example.mymusicdb.model.service.UserServiceModel;
import com.example.mymusicdb.service.AlbumService;
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
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    private final HttpSession httpSession;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper, HttpSession httpSession) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String addAlbums(){
        return "add-album";
    }

    @PostMapping("/add")
    public String confirmAlbum(@Valid AlbumAddBindingModel albumAddBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("albumAddBindingModel", albumAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        AlbumServiceModel albumServiceModel = modelMapper.
                map(albumAddBindingModel, AlbumServiceModel.class);

        UserServiceModel userServiceModel = modelMapper
                .map(httpSession.getAttribute("user"), UserServiceModel.class);


        albumService.addAlbum(albumServiceModel, userServiceModel);

        return "redirect:/";
    }

    @ModelAttribute
    public AlbumAddBindingModel albumAddBindingModel(){
        return new AlbumAddBindingModel();
    }
}
