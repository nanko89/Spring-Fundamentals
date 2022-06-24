package com.example.battleships.service.impl;

import com.example.battleships.model.binding.HomeFireBindingModel;
import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.model.view.ShipViewModel;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.service.CategoryService;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ShipServiceImpl(ShipRepository shipRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper) {
        this.shipRepository = shipRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isFreeName(String name) {
        return this.shipRepository
                .findByNameIgnoreCase(name)
                .isEmpty();
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel, UserServiceModel currentUser) {

        User user = this.userService
                .findByUsername(currentUser.getUsername());

        Ship ship = this.modelMapper
                .map(shipServiceModel, Ship.class);

        Category category = this.categoryService
                .findByName(shipServiceModel.getCategory());

        ship.setUser(user).setCategory(category);

        this.shipRepository.save(ship);

    }

    @Override
    public List<ShipViewModel> defenderShips(UserServiceModel userServiceModel) {

        User user = userService.findByUsername(userServiceModel.getUsername());

        return allShips()
                .stream()
                .filter(shipViewModel -> !shipViewModel.getUser().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> allShips() {
        return shipRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Ship::getName)
                        .thenComparing(Ship::getHealth)
                        .thenComparing(Ship::getPower))
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> attackerShips(UserServiceModel userServiceModel) {
        User user = userService.findByUsername(userServiceModel.getUsername());
        return allShips()
                .stream()
                .filter(shipViewModel -> shipViewModel.getUser().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void fight(HomeFireBindingModel homeFireBindingModel) {
        Ship attacker = shipRepository
                .findById(homeFireBindingModel.getAttackerShip()).orElse(null);

        Ship defender = shipRepository
                .findById(homeFireBindingModel.getDefenderShip()).orElse(null);

        long healthDefender = defender.getHealth() - attacker.getPower();
        if (healthDefender <= 0) {
            shipRepository
                    .deleteById(homeFireBindingModel.getDefenderShip());
        } else {
            shipRepository
                    .save(defender.setHealth(healthDefender));
        }

    }
}
