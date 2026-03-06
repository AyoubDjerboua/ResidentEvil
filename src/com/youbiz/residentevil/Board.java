package com.youbiz.residentevil;
import com.youbiz.residentevil.model.Player;

import java.util.Random;

public class Board {

    private Random random = new Random();
    private int compteurLancers = 0;

    public int rollDice() {
        return random.nextInt(3) + 1;
    }

    public void avancer(Player player) {
        int dice = rollDice();
        compteurLancers +=1;

        System.out.println("Lancer numéro : " + compteurLancers);
        System.out.println("Résultat du dé : " + dice);

        player.move(dice);
        System.out.println(player.getName() +
                " est maintenant dans la salle numéro " +
                player.getPosition());
    }
}