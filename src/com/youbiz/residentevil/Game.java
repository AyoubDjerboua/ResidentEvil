package com.youbiz.residentevil;
import java.util.Scanner;

public class Game
{
    private Player player;
    private Zombie zombie;
    Scanner scanner = new Scanner(System.in);

    public void start()
    {
        Combat combat = new Combat(scanner);

        // Choix du personnage
        System.out.println("RESIDENT EVIL\nChoisissez votre personnage :");
        System.out.println("1. Chris Redfield (100 HP, 15 dégâts, 15 de défense");
        System.out.println("2. Jill Valentine (80HP, 20 dégâts , 5 de défense");
        String choice = scanner.nextLine();
        if(choice.equals("1"))
        {
            player = new Player ("Chris Redfield", 120, 20, 15);
        }
        else if (choice.equals("2"))
        {
            player = new Player("Jill Valentine", 80, 30, 5);
        }
        else if (choice.equals("3"))
        {
            player = new Player("Barry Burton", 100, 50, 10);
        }
        else
        {
            player = new Player("Zombie", 50, 20, 0);
            System.out.println("Choix invalide, vous jouez un zombie");
        }
        System.out.println(player.getName() + " entre dans le manoir");

        Board board = new Board();
        for(int i = 0; i < 20; i++) // nombre de tours
        {
            board.avancer(player);
            int position = player.getPlayerPosition();

            System.out.println("La salle est vide... pour l'instant.");
            System.out.println("Que voulez-vous faire ?\n1. Avancer\n2. Se Reposer");

            String avancerChoice = scanner.nextLine();
            if(avancerChoice.equals("1")) {
                System.out.println("Vous décidez de continuer à avancer...");
            }
            else {
                System.out.println("Vous faites une pause pour reprendre votre souffle, mais le manoir est rempli de dangers, vous perdez du temps précieux...");
            }

            // Combat toutes les 3 salles
            if(position % 3 == 0) {
                System.out.println("Vous entendez des bruits de pas... Un zombie apparaît !");
                Zombie zombie = new Zombie("Zombie sauvage", 50 + position, 10 + position);

                // Lancement du combat
                boolean alive = combat.start(player, zombie);

                // Vérification de la vie avant de proposer de continuer
                if (!alive) {
                    System.out.println("Game Over !");
                    break; // on sort de la boucle si le joueur est mort
                }

                // Proposer de continuer seulement si le joueur est vivant
                System.out.println("Vous entendez du bruit au loin, que voulez-vous faire ?\n1. Avancer\n2. Se Reposer\n3. Fuir");
                String continueChoice = scanner.nextLine();

                if(continueChoice.equals("1")) {
                    System.out.println("Vous décidez de continuer à avancer...");
                }
                else if(continueChoice.equals("2")) {
                    System.out.println("Vous faites une pause pour reprendre votre souffle, mais le manoir est rempli de dangers, vous perdez du temps précieux...");
                }
                else {
                    System.out.println("Vous faites demi-tour et quittez le manoir, votre corps demeurera introuvable...");
                    break; // sortie du jeu
                }
            }

        }
    }
}