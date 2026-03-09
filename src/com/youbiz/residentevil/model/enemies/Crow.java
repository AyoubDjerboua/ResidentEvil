package com.youbiz.residentevil.model.enemies;
import com.youbiz.residentevil.model.Enemy;
import com.youbiz.residentevil.model.Player;

public class Crow extends Enemy {
    int compteurCorbo = 7;
    public Crow() {
        super("Nuée de corbeaux", 120, 7);
    }


    // Comportement spécifique de Cerberus
    @Override
    public void attack(Player player, boolean playerBlocks) {
        super.attack(player, playerBlocks);//utilise la méthode de base pour afficher le message d'attaque
        for (int i = 0; i < compteurCorbo; i++){
            if (playerBlocks) {
                int reducedDamage = damage - player.getBlock();
                if (reducedDamage < 0) reducedDamage = 0;// évite les PV négatifs

                System.out.println(player.getName() + " se prépare à bloquer !");
                player.takeDamage(reducedDamage);
            }
            else{
                player.takeDamage(damage);
            }
        }
        compteurCorbo--;
        System.out.println("Un des corbeaux s'en va, il en reste " + compteurCorbo);
        if(compteurCorbo <= 0){
            health = 0;
            System.out.println("Les corbeaux se dispersent dans le ciel !");
        }
    }
}