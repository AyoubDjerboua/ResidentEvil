package com.youbiz.residentevil;
import com.youbiz.residentevil.model.characters.*;//appelle tous les personnages
import com.youbiz.residentevil.model.enemies.* ;//appelle direct tous les ennemis
import com.youbiz.residentevil.model.Enemy;
import com.youbiz.residentevil.model.Player;

import java.util.Scanner;
import java.util.Random;

public class Game
{
    private Player player;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random(); // pour choisir les ennemis aléatoirement
    private final Menu menu = new Menu();

    public void start()
    {
        Combat combat = new Combat(scanner);
        menu.afficherTitre();

        // Choix du personnage
        player = choisirPersonnage();


        Board board = new Board();
        for(int i = 0; i < 20; i++) {  // nombre de lancers de dés, donc nombre de salles à explorer
            board.avancer(player);
            int position = player.getPosition();

            if(position % 2 == 0) { //toutes les salles multiples de 2 contiennent un zombie
                narration("Vous entendez des bruits inquiétants...");
                Enemy enemy = getRandomEnemy(position);


                boolean alive = combat.start(player, enemy);// Lancement du combat
                // Vérification de la vie avant de proposer de continuer
                if (!alive) {
                    menu.afficherMessage("Game Over !");
                    break; // on sort de la boucle si le joueur est mort
                }
                // Choix du joueur (seulement s'il est vivant)
                menu.afficherChoixPostCombat();
                String choiceAction = scanner.nextLine();

                switch (choiceAction) {
                    case "1": menu.afficherMessage("Vous continuez à explorer le manoir...");
                        break;
                    case "2": menu.afficherMessage("Vous prenez un moment pour reprendre des forces.");
                        player.heal(20);
                        break;
                    default: menu.afficherMessage("Vous faites demi-tour et quittez le manoir...");
                        return;
                }
            }
            else { // salle vide
                menu.afficherMessage("La salle semble vide.");
                menu.afficherActionsSalleVide();

                String emptyChoice = scanner.nextLine();
                switch (emptyChoice) {
                    case "1": menu.afficherMessage("Vous continuez à explorer le manoir...");
                        break;
                    case "2": menu.afficherMessage("Vous prenez un moment pour reprendre des forces.");
                        player.heal(20);
                        break;
                    case "3": menu.afficherMessage("Vous explorez la salle...");
                        break;
                    default: menu.afficherMessage("Choix invalide, vous continuez à explorer le manoir...");
                }
            }
        }
    }

    private Player choisirPersonnage() {
        Player player = null;
        while (player == null) {
            menu.afficherChoixPersonnage();
            menu.afficherMessage("1. " + new ChrisRedfield());
            menu.afficherMessage("2. " + new JillValentine());
            menu.afficherMessage("3. " + new BarryBurton());

            String characterChoice = scanner.nextLine();
            switch (characterChoice) {
                case "1": player = new ChrisRedfield(); break;
                case "2": player = new JillValentine(); break;
                case "3": player = new BarryBurton(); break;
                default: menu.afficherMessage("Choix invalide, veuillez réessayer.");
            }
        }
        menu.afficherMessage(player.getName() + " entre dans le manoir !");
        return player;
    }

    private Enemy getRandomEnemy(int position) { //la position du joueur influence la difficulté des ennemis rencontrés
        int enemyType = random.nextInt(4); // 3 types d'ennemis
        switch (enemyType) {
            case 0: return new Zombie();
            case 1: return new Cerberus();
            case 2: return new Hunter();
            case 3: return new Crow();
            default: return new Zombie();
        }
    }

    private void narration(String message) {
        System.out.println("> " + message);
    }
}