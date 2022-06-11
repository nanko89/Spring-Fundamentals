package com.example.battleships.service.impl;

import com.example.battleships.model.binding.HomeBindingModel;
import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.model.view.ShipViewModel;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isFreeName(String name) {
        return shipRepository.findByNameIgnoreCase(name).isEmpty();
    }

    @Override
    public void addShips(ShipServiceModel serviceModel, UserServiceModel currentUser) {
        Ship ship = modelMapper.map(serviceModel, Ship.class);
        ship.setUser(modelMapper.map(currentUser, User.class));
        shipRepository.save(ship);
    }


    @Override
    public List<ShipViewModel> findAll() {
        return shipRepository.findAll()
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .sorted((s1, s2) -> {
                    if (s1.getName().compareTo(s2.getName()) == 0) {

                        if (s1.getHealth().compareTo(s2.getHealth()) == 0) {
                            return s1.getPower().compareTo(s2.getPower());

                        } else {
                            return s1.getHealth().compareTo(s2.getHealth());

                        }
                    } else {

                        return s1.getName().compareTo(s2.getName());
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void fight(HomeBindingModel homeBindingModel) {
        Optional<Ship> attacker = shipRepository
                .findById(homeBindingModel.getAttackerShip());

        Optional<Ship> defender = shipRepository
                .findById(homeBindingModel.getDefenderShip());

        if (attacker.isEmpty() || defender.isEmpty()) {
            return;
        }

        Ship shipDef = defender.get();
        Ship shipAttack = attacker.get();


        int dHealth = shipDef.getHealth() - shipAttack.getPower();

        if (dHealth <= 0) {
            shipRepository.deleteById(homeBindingModel.getDefenderShip());
            return;
        } else {
            shipDef.setHealth(dHealth);
        }

        shipRepository.save(shipDef);

    }
}

