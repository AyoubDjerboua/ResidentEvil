package com.youbiz.residentevil;
import com.youbiz.residentevil.characters.Player;
import com.youbiz.residentevil.enemies.Enemy;

import java.util.Scanner;

public class Combat {
    private Scanner scanner;

    public Combat(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean start(Player player, Enemy enemy) {
        System.out.println("Un "+ enemy.getName() + " apparaît !");

        while(player.isAlive() && enemy.isAlive()) {
            System.out.println("\n" + player.getName() + " : " + player.getHealth() + "PV");
            System.out.println(enemy.getName() + " : " + enemy.getHealth() + "PV");

            System.out.println("1. Attaquer\n2. Bloquer");
            String choice = scanner.nextLine();

            boolean playerBlocks = choice.equals("2");

            if(choice.equals("1")) {
                player.attack(enemy);
            } else if(playerBlocks) {
                System.out.println(player.getName() + " se prépare à bloquer !");
            } else {
                System.out.println("Action invalide !");
            }

            if(enemy.isAlive()) {
                enemy.attack(player, playerBlocks);
            }
        }

        if(player.isAlive()) {
            System.out.println(player.getName() + " a vaincu " + enemy.getName() + " !");
            return true;
        } else {
            System.out.println(player.getName() + " est mort...");
            return false;
        }
    }
}