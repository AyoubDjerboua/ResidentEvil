package com.youbiz.residentevil;
import java.util.Scanner;

public class Game
{
    private Player player;
    private Zombie zombie;

    public void start()
    {
        System.out.println("Bienvenue dans le manoir Spencer");
        player = new Player();//initialisation des attributs selon les paramètres du constructeur Player
        zombie = new Zombie("Zombie", 30, 15);//pareil

        System.out.println(player.getName() + " entre dans la pièce");
        System.out.println(player.getName() + " tombe nez à nez avec un zombie !");
        fight();
    }

    private void fight()
    {
        while(player.isAlive() && zombie.isAlive())
        {
            //exemple attaque
            zombie.takeDamage(player.getDamage());
            if(zombie.isAlive())
            {
                zombie.attack(player);
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
