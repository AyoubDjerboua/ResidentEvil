package com.youbiz.residentevil.model.enemies;
import com.youbiz.residentevil.model.Enemy;
import com.youbiz.residentevil.model.Player;

public class Hunter extends Enemy {

    public Hunter() {
        super("Hunter", 100, 20);
    }

    // Comportement spécifique de Hunter
    @Override//@Override indique que cette méthode redéfinit une méthode de la classe parente
    public void attack(Player player, boolean playerBlocks) {
        super.attack(player, playerBlocks);//utilise la méthode de base pour afficher le message d'attaque
        int imblockableDamage = damage;

        if(playerBlocks) {
            System.out.println("L'attaque du " + name + " est imblocable !");
            player.takeDamage(imblockableDamage);

        } else {
            player.takeDamage(imblockableDamage);
        }
    }
}