package com.youbiz.residentevil.model.enemies;
import com.youbiz.residentevil.model.Enemy;
import com.youbiz.residentevil.model.Player;

public class Zombie extends Enemy {

    public Zombie(String name, int health, int damage) {
        super(name, health, damage);
    }

    // Comportement spécifique de Zombie
    @Override
    public void attack(Player player, boolean playerBlocks) {
        super.attack(player, playerBlocks);

        if(playerBlocks) {
            int reducedDamage = damage - player.getBlock();
            if(reducedDamage < 0) reducedDamage = 0; // évite les PV négatifs

            System.out.println(player.getName() + " se prépare à bloquer !");
            player.takeDamage(reducedDamage);

        } else {
            player.takeDamage(damage);
        }
    }
}