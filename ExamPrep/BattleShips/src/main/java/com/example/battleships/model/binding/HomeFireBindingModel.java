package com.example.battleships.model.binding;

import javax.validation.constraints.NotNull;

public class HomeFireBindingModel {

    @NotNull
    private Long attackerShip;
    @NotNull
    private Long defenderShip;

    public HomeFireBindingModel() {
    }

    public Long getAttackerShip() {
        return attackerShip;
    }

    public HomeFireBindingModel setAttackerShip(Long attackerShip) {
        this.attackerShip = attackerShip;
        return this;
    }

    public Long getDefenderShip() {
        return defenderShip;
    }

    public HomeFireBindingModel setDefenderShip(Long defenderShip) {
        this.defenderShip = defenderShip;
        return this;
    }
}
