package com.youbiz.residentevil;
import java.util.Scanner;

public class Game
{
    private Player player;
    private Zombie zombie;
    Scanner scanner = new Scanner(System.in);

    public void start()
    {
        System.out.println("RESIDENT EVIL\nChoisissez votre personnage :");
        System.out.println("1. Chris Redfield (100 HP, 15 dégâts, 15 de défense");
        System.out.println("2. Jill Valentine (80HP, 20 dégâts , 5 de défense");

        String choice = scanner.nextLine();
        if(choice.equals("1"))
        {
            player = new Player ("Chris Redfield", 120, 20, 15);
        }
        else if (choice.equals("2"))
        {
            player = new Player("Jill Valentine", 80, 30, 5);
        }
        else if (choice.equals("3"))
        {
            player = new Player("Barry Burton", 100, 50, 10);
        }
        else
        {
            player = new Player("Zombie", 50, 20, 0);
            System.out.println("Choix invalide, vous jouez un zombie");
        }
        System.out.println(player.getName() + " entre dans le manoir");


        zombie = new Zombie("Zombie", 60, 15);
        System.out.println(player.getName() + " tombe nez à nez avec un zombie !\n");

        boolean alive = fight();
        if(alive)
        {
            System.out.println("\nVous entendez du bruit provenant d'une pièce voisine.\nVoulez-vous continuer ?\n1.Oui\n2.Non\n");
            String continueChoice = scanner.nextLine();

            if(continueChoice.equals("1"))
            {
                secondEncounter();
            }
            else {
                System.out.println("Vous quittez le manoir, votre corps demeurera introuvable...");
            }
        }

    }



    private boolean fight()
    {
        System.out.println("DEBUT DU COMBAT\nLe zombie approche...\n");
        while(player.isAlive() && zombie.isAlive())
        {
            System.out.println(player.getName() + " : " + player.getHealth() + "PV");
            System.out.println(zombie.getName() + " : " + zombie.getHealth() + "PV");
            System.out.println("\nQue voulez-vous faire ?\n1. Attaquer\n2. Bloquer");
            String battleChoice = scanner.nextLine();

            if(battleChoice.equals("1")) {
                player.attack(zombie);
            } else if(battleChoice.equals("2")) {
                System.out.println(player.getName() + " se prépare à bloquer l'attaque !");
            } else {
                System.out.println("Action invalide, vous perdez votre tour !");
            }

            if(zombie.isAlive())
            {
                if(battleChoice.equals("2"))
                {
                    zombie.attackBlocked(player);
                }
                else
                {
                    zombie.attack(player);
                }
                System.out.println("\nTOUR SUIVANT\n");
            }

        }
        if(player.isAlive()){
            System.out.println(player.getName() + " a vaincu le zombie !");
            return true; //rend possible le fait de continuer la partie
        }
        else
        {
            System.out.println(player.getName() + " est mort...");
            return false;//rend impossible de continuer la partie, bah oui t'es mort
        }
    }

    private void secondEncounter()
    {
        System.out.println("NOUVELLE SALLE\nUn nouveau zombie surgit !\n");
        zombie = new Zombie("Zombie affamé", 80, 20);
        fight();
    }


    private void avancer()
    {

    }
}
