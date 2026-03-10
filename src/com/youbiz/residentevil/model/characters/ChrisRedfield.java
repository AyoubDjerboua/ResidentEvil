package com.youbiz.residentevil.model.characters;
import com.youbiz.residentevil.model.Player;
import com.youbiz.residentevil.model.items.equipment.weapons.*;

public class ChrisRedfield extends Player {
    public ChrisRedfield()
    {
        super("Chris Redfield", 120, 10, 6, 15);

        //Starting weapon
        Pistol pistol = new Pistol();
        this.equipWeapon(pistol);
    }
}

