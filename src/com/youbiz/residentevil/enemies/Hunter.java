package com.youbiz.residentevil.enemies;
import com.youbiz.residentevil.characters.Player;

public class Hunter extends Enemy {

    public Hunter(String name, int health, int damage) {
        super(name, health, damage);
    }

    // Comportement spécifique de Zombie
    @Override//@Override indique que cette méthode redéfinit une méthode de la classe parente
    public void attack(Player player, boolean playerBlocks) {
        if(playerBlocks) {
            int imblockableDamage = damage;
            System.out.println("L'attaque de " + name + " est imblocable. Dégâts subis : " + imblockableDamage);
            player.takeDamage(imblockableDamage);

        } else {
            System.out.println(name + " attaque " + player.getName() + " pour " + damage + " dégâts !");
            player.takeDamage(damage);
        }
    }
}