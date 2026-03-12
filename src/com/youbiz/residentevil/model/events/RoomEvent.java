package com.youbiz.residentevil.model.events;

import com.youbiz.residentevil.model.Player;

public interface RoomEvent {

    boolean trigger(Player player);

}