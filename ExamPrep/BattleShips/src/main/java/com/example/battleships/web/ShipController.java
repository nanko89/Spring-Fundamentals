package com.example.battleships.web;

import com.example.battleships.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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


}
