package com.youbiz.residentevil.model.characters;

import com.youbiz.residentevil.model.Player;
import com.youbiz.residentevil.model.items.equipment.weapons.*;

public class JillValentine extends Player {
    public JillValentine() {
        super("Jill Valentine", 80, 15, 2, 5);

        //Starting weapon
        Shotgun shotgun = new Shotgun();
        this.equipWeapon(shotgun);
    }
}
