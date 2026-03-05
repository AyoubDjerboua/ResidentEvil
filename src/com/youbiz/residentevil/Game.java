package com.youbiz.residentevil;
import com.youbiz.residentevil.characters.BarryBurton;
import com.youbiz.residentevil.characters.*;//appelle tous les personnages
import com.youbiz.residentevil.enemies.* ;//appelle direct tous les ennemis

import java.util.Scanner;
import java.util.Random;

public class Game
{
    private Player player;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random(); // pour choisir les ennemis aléatoirement

    public void start()
    {
        Combat combat = new Combat(scanner);

        System.out.println("""
        ██████╗ ███████╗███████╗██╗██████╗ ███████╗███╗   ██╗████████╗
        ██╔══██╗██╔════╝██╔════╝██║██╔══██╗██╔════╝████╗  ██║╚══██╔══╝
        ██████╔╝█████╗  ███████╗██║██║  ██║█████╗  ██╔██╗ ██║   ██║
        ██╔══██╗██╔══╝  ╚════██║██║██║  ██║██╔══╝  ██║╚██╗██║   ██║
        █       █║  ██║███████╗███████║██║██████╔╝███████╗██║ ╚████║   ██║
        ╚═╝  ╚═╝╚══════╝╚══════╝╚═╝╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝
        
        ███████╗██╗   ██╗██╗██╗
        ██╔════╝██║   ██║██║██║
        █████╗  ██║   ██║██║██║
        ██╔══╝  ╚██╗ ██╔╝██║██║
        ███████╗ ╚████╔╝ ██║███████╗
        ╚══════╝  ╚═══╝  ╚═╝╚══════╝
        """);

        // Choix du personnage
        Player player = null;
        while(player == null) {
            System.out.println("\nChoisissez votre personnage :");
            System.out.println("1. Chris Redfield" + " (120HP, 20 dégâts, 15 de défense)");
            System.out.println("2. Jill Valentine" + " (80HP, 30 dégâts, 5 de défense)");
            System.out.println("3. Barry Burton (100 HP, 50 dégâts, 10 défense)");

            String characterChoice = scanner.nextLine();
            switch (characterChoice) {
                case "1": player = new ChrisRedfield(); break;
                case "2": player = new JillValentine(); break;
                case "3": player = new BarryBurton(); break;
                default: System.out.println("Choix invalide, veuillez rééssayer");
            }
        }
        System.out.println(player.getName() + " entre dans le manoir");


        Board board = new Board();
        for(int i = 0; i < 10; i++) // nombre de lancers de dés, donc nombre de salles à explorer
        {
            board.avancer(player);
            int position = player.getPlayerPosition();

            if(position % 2 == 0) { //toutes les salles multiples de 2 contiennent un zombie
                System.out.println("Vous entendez des bruits inquiétants...");
                Enemy enemy = getRandomEnemy(position);

                // Lancement du combat
                boolean alive = combat.start(player, enemy);

                // Vérification de la vie avant de proposer de continuer
                if (!alive)
                {
                    System.out.println("Game Over !");
                    break; // on sort de la boucle si le joueur est mort
                }
                // Choix du joueur (seulement s'il est vivant)
                System.out.println("""
                Que voulez-vous faire ?

                1. Continuer à explorer
                2. Se reposer (+20 PV)
                3. Fuir le manoir
                """);

                String choiceAction = scanner.nextLine();

                if(choiceAction.equals("1")) {
                    System.out.println("Vous continuez à explorer le manoir...");
                }

                else if(choiceAction.equals("2")) {
                    System.out.println("Vous prenez un moment pour reprendre des forces.");
                    player.heal(20);
                }

                else {
                    System.out.println("Vous faites demi-tour et quittez le manoir, votre corps demeurera introuvable...");
                    break;
                }
            }
            else
            {
                System.out.println("La salle semble vide.");
                System.out.println("""
                Que voulez-vous faire ?

                1. Continuer à explorer
                2. Se reposer (+20 PV)
                """);

                String emptyChoice = scanner.nextLine();
                if(emptyChoice.equals("1")) {
                    System.out.println("Vous continuez à explorer le manoir...");
                }

                else if(emptyChoice.equals("2")) {
                    System.out.println("Vous prenez un moment pour reprendre des forces.");
                    player.heal(20);
                }

                else {
                    System.out.println("Action invalide, vous faites une crise cardiaque et mourrez.");
                    break;
                }
            }
        }
    }

    private Enemy getRandomEnemy(int position) { //la position du joueur influence la difficulté des ennemis rencontrés
        int enemyType = random.nextInt(3); // 3 types d'ennemis
        switch (enemyType) {
            case 0:
                return new Zombie("Zombie sauvage", 50 + position, 5 + position);
            case 1:
                return new Cerberus("Cerbère enragé", 80 + position, 10 + position);
            case 2:
                return new Hunter("Hunter", 100 + position, 15 + position);
            default:
                return new Zombie("Zombie sauvage", 50 + position, 10 + position);
        }
    }
}