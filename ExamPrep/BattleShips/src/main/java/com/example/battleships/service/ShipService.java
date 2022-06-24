package com.example.battleships.service;

import com.example.battleships.model.binding.HomeFireBindingModel;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    boolean isFreeName(String name);

    void addShip(ShipServiceModel shipServiceModel, UserServiceModel currentUser);

    List<ShipViewModel> defenderShips(UserServiceModel user);

    List<ShipViewModel> allShips();

    List<ShipViewModel> attackerShips(UserServiceModel user);

    void fight(HomeFireBindingModel homeFireBindingModel);
}
