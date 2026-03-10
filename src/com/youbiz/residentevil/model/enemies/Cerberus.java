package com.youbiz.residentevil.model.enemies;
import com.youbiz.residentevil.model.Enemy;
import com.youbiz.residentevil.model.Player;

public class Cerberus extends Enemy {

    public Cerberus() {
        super("Cerbère", 75, 10);
    }

    // Comportement spécifique de Cerberus
    @Override
    public void attack(Player player, boolean playerBlocks) {
        super.attack(player, playerBlocks);//utilise la méthode de base pour afficher le message d'attaque
        if(playerBlocks) {
            int reducedDamage = damage - player.getBlock();
            if(reducedDamage < 0) reducedDamage = 0;// évite les PV négatifs

            System.out.println(player.getName() + " se prépare à bloquer !");
            player.takeDamage(reducedDamage);

            System.out.println(name + " attaque à nouveau");
            player.takeDamage(damage);

        } else {
            player.takeDamage(damage);
            System.out.println(name + " attaque à nouveau");
            player.takeDamage(damage);
        }
    }
}