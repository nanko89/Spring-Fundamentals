package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    private final UserService userService;
    private final CurrentUser currentUser;

    public SongController(SongService songService, UserService userService, CurrentUser currentUser) {
        this.songService = songService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String add(){
        if (!currentUser.isLogged()){
            return "redirect:/";
        }
        return "song-add";
    }

    @PostMapping("/add")
    public String confirmSong(@Valid SongAddDTO songAddDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("songAddDTO", songAddDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.songAddDTO",
                            bindingResult);

            return "redirect:add";
        }

        songService.addSong(songAddDTO);
        return "redirect:/";
    }


    @GetMapping("/add/{id}")
    public String addCurrentSong(@PathVariable Long id){

        Song song = songService.findById(id);

        userService.addSongToPlaylist(song);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String clearPlaylist(){
        userService.clearPlaylist();
        return "redirect:/";
    }


    @ModelAttribute
    public SongAddDTO songAddDTO(){
        return new SongAddDTO();
    }
}
