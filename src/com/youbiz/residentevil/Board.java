package com.youbiz.residentevil;
import java.util.Random;

public class Board {

    private Random random = new Random();

    public int rollDice() {
        return random.nextInt(6) + 1;
    }

    public void avancer(Player player) {
        int dice = rollDice();
        System.out.println("Résultat du dé : " + dice);

        player.move(dice);
        System.out.println(player.getName() +
                " est maintenant dans la salle numéro " +
                player.getPlayerPosition());
    }
}