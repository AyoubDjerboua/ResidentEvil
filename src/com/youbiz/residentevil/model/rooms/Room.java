package com.youbiz.residentevil.model.rooms;

import com.youbiz.residentevil.model.Player;
import com.youbiz.residentevil.model.events.RoomEvent;

public class Room {

    private RoomEvent event;

    public Room(RoomEvent event) {
        this.event = event;
    }

    public void enter(Player player) {
        event.trigger(player);
    }

}