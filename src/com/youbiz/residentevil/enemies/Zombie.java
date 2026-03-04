package com.youbiz.residentevil.enemies;
import com.youbiz.residentevil.characters.Player;

public class Zombie extends Enemy {

    public Zombie(String name, int health, int damage) {
        super(name, health, damage);
    }

    // Comportement spécifique de Zombie
    @Override
    public void attack(Player player, boolean playerBlocks) {
        if(playerBlocks) {
            int reducedDamage = damage - player.getBlockValue();
            if(reducedDamage < 0) reducedDamage = 0; // évite les PV négatifs
            System.out.println("L'attaque de " + name + " est bloquée. Dégâts réduits à " + reducedDamage);
            player.takeDamage(reducedDamage);
        } else {
            System.out.println(name + " attaque " + player.getName() + " pour " + damage + " dégâts !");
            player.takeDamage(damage);
        }
    }
}