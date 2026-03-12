package com.youbiz.residentevil.model.events;

import com.youbiz.residentevil.model.Player;
import com.youbiz.residentevil.model.Enemy;
import com.youbiz.residentevil.Combat;
import com.youbiz.residentevil.Menu;

import java.util.Scanner;

public class CombatEvent implements RoomEvent {
    private Enemy enemy;
    private Combat combat;
    private Menu menu;
    private Scanner scanner;

    public CombatEvent(Enemy enemy, Combat combat, Menu menu, Scanner scanner)
    {
        this.enemy = enemy;
        this.combat = combat;
        this.menu = menu;
        this.scanner = scanner;
    }
    @Override
    public boolean trigger(Player player)
    {
        menu.afficherMessage("Un " + enemy.getName() + " apparaît !");
        boolean alive = combat.start(player, enemy);
        if (!alive) return false;

        //choix après combat
        menu.afficherChoixPostCombat();
        String choiceAction = scanner.nextLine();

        return true;

    }
}