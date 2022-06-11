package com.example.battleships.model.binding;

import javax.validation.constraints.NotNull;

public class HomeBindingModel {
    @NotNull
    private Long attackerShip;

    @NotNull
    private Long defenderShip;

    public HomeBindingModel() {
    }

    public Long getAttackerShip() {
        return attackerShip;
    }

    public HomeBindingModel setAttackerShip(Long attackerShip) {
        this.attackerShip = attackerShip;
        return this;
    }

    public Long getDefenderShip() {
        return defenderShip;
    }

    public HomeBindingModel setDefenderShip(Long defenderShip) {
        this.defenderShip = defenderShip;
        return this;
    }
}

