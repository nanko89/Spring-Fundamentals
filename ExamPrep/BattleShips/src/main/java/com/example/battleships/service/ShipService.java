package com.example.battleships.service;

import com.example.battleships.model.binding.HomeBindingModel;
import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    boolean isFreeName(String name);

    void addShips(ShipServiceModel serviceModel, UserServiceModel currentUser);

    List<ShipViewModel> findAll();

    void fight(HomeBindingModel homeBindingModel);

}
