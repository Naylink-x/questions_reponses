package fr.questions_reponses;

import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choix = 0;
        Themes T = new Themes();

        do {
            choix = menuPrincipal();

            switch (choix) {
                case 1:
                    T.showAllThemes();
                    break;

                case 2:
                    break;

                case 3 :
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    sortir();
                    break;

                default:
                    System.out.println("Cette option n'existe pas !");
            }
        } while (choix != 8);


        PhaseTrois PTrois = new PhaseTrois();
    }

    public static int menuPrincipal() {
        int tmp;

        System.out.println("1. Afficher les 10 thèmes");
        System.out.println("2. Créer une liste de questions pour chaque thème");
        System.out.println("3. Afficher toutes les questions d'un certain niveau");
        System.out.println("4. Ajouter une question à la liste d'un thème");
        System.out.println("5. Supprimer une question de la liste d'un thème");
        System.out.println("6. Créer le tableau de joueurs et afficher leurs états");
        System.out.println("7. Lancer une partie du jeu avec 4 joueurs");
        System.out.println("8. Quitter le jeu");
        System.out.println();
        System.out.println("Quel est votre choix ?");
        tmp = in.nextInt();

        return tmp;
    }

    public static void sortir( ) {
        System.out.println("Au revoir et a bientot");
        System.exit(0) ;
    }
}