package com.youbiz.residentevil;

import java.util.Scanner;

public class Combat {

    private Scanner scanner;

    public Combat(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean start(Player player, Zombie zombie) {

        System.out.println("DEBUT DU COMBAT\nLe zombie approche...\n");

        while(player.isAlive() && zombie.isAlive()) {

            System.out.println(player.getName() + " : " + player.getHealth() + " PV");
            System.out.println(zombie.getName() + " : " + zombie.getHealth() + " PV");
            System.out.println("\nQue voulez-vous faire ?\n1. Attaquer\n2. Bloquer");

            String battleChoice = scanner.nextLine();

            if(battleChoice.equals("1")) {
                player.attack(zombie);
            }
            else if(battleChoice.equals("2")) {
                System.out.println(player.getName() + " se prépare à bloquer l'attaque !");
            }
            else {
                System.out.println("Action invalide, vous perdez votre tour !");
            }

            if(zombie.isAlive()) {
                if(battleChoice.equals("2")) {
                    zombie.attackBlocked(player);
                }
                else {
                    zombie.attack(player);
                }

                System.out.println("\nTOUR SUIVANT\n");
            }
        }

        if(player.isAlive()) {
            System.out.println(player.getName() + " a vaincu le zombie !");
            return true;
        } else {
            System.out.println(player.getName() + " est mort...");
            return false;
        }
    }
}