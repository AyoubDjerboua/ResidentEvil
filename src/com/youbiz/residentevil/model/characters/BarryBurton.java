package com.youbiz.residentevil.model.characters;
import com.youbiz.residentevil.model.Player;
import com.youbiz.residentevil.model.items.equipment.weapons.*;


public class BarryBurton extends Player {
    public BarryBurton() {
        super("Barry Burton", 100, 10, 5, 10);

        //Starting weapon
        Magnum magnum = new Magnum();
        this.equipWeapon(magnum);
    }
}