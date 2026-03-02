package com.youbiz.residentevil;
import java.util.Scanner;

public class Game
{
    private Player player;
    private Zombie zombie;
    Scanner scanner = new Scanner(System.in);

    public void start()
    {
        System.out.println("RESIDENT EVIL");
        System.out.println("Choisissez votre personnage : ");
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

        //System.out.println(player.getName() + " entre dans la pièce");
        System.out.println(player.getName() + " tombe nez à nez avec un zombie !\n");
        fight();
    }

    private void fight()
    {
        System.out.println("""
====================
   COMBAT START
====================

Le zombie approche...
""");
        while(player.isAlive() && zombie.isAlive())
        {
            System.out.println(player.getName() + " :" + player.getHealth() + "PV");
            System.out.println(zombie.getName() + " :" + zombie.getHealth() + "PV");
            System.out.println("");
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Attaquer");
            System.out.println("2. Bloquer");
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
                System.out.println("""
------------------------
Tour suivant !
------------------------
""");
            }

        }
        if(player.isAlive()){
            System.out.println(player.getName() + " a vaincu le zombie !");
        }
        else
        {
            System.out.println(player.getName() + " est mort...");
        }
    }

    private void avancer()
    {

    }
}
