package com.youbiz.residentevil.model.events;

import com.youbiz.residentevil.model.Player;
import com.youbiz.residentevil.Menu;
import java.util.Scanner;

public class EmptyRoomEvent implements RoomEvent {

    private Menu menu;
    private Scanner scanner;

    public EmptyRoomEvent(Menu menu, Scanner scanner) {
        this.menu = menu;
        this.scanner = scanner;
    }

    @Override
    public boolean trigger(Player player) {
        menu.afficherMessage("La salle semble vide...");
        menu.afficherActionsSalleVide();

        String choice = scanner.nextLine();
        switch(choice) {
            case "2":
                player.heal(20);
                break;
            case "3":
                menu.afficherMessage("Vous explorez la salle...");
                break;
            default:
                menu.afficherMessage("Vous continuez à explorer le manoir...");
        }
        return true;
    }
}