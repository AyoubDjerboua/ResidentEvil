package com.youbiz.residentevil.model.events;

import com.youbiz.residentevil.model.Player;

public class LootEvent implements RoomEvent {

    @Override
    public boolean trigger(Player player) {
        System.out.println("Vous trouvez un objet !");
        return true;
    }

}

//OBSOLETE, A REVOIR