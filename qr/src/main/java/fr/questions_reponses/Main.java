package fr.questions_reponses;

import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choix = 0;
        Joueurs J = new Joueurs();
        Themes T = new Themes();
        Questions Q = new Questions();

        //TODO: gestion des erreurs, au moins concernant les saisies utilisateurs
        do {
            choix = menuPrincipal();

            switch (choix) {
                case 1:
                    T.showAllThemes();
                    break;

                case 2:
                    Q.showAll();
                    break;

                case 3 :
                    int niveau;

                    System.out.println("Quel est le niveau des questions que vous souhaitez afficher ?");
                    niveau = in.nextInt();

                    for (String theme : T.getThemes()) {
                        for (Question question : Q.getListeQuestionList().get(theme)) {
                            if (question.niveau == niveau) {
                                System.out.println();
                                question.afficherQuestion();
                            }
                        }
                    }
                    break;

                case 4:
                    Question question = new Question();
                    question = question.saisieQuestion();
                    System.out.println("Voici la question que vous avez créé :");
                    System.out.println();
                    question.afficherQuestion();
                    Q.addQuestion(question.theme, question);
                    System.out.println();
                    System.out.println("Voici la liste des questions du thème pour lequel vous avez ajouté une question :");
                    System.out.println();
                    Q.selectQuestions(question.theme);
                    break;

                case 5:
                    String theme = "";
                    int count = 0;
                    int numeroQuestion;

                    do {
                        if (count > 0) {
                            System.out.println("Ce thème n'existe pas, renseignez un thème qui existe parmi les suivants :");
                            T.showAllThemes();
                        }
                        System.out.println("Pour quel thème souhaitez-vous supprimer une question ?");
                        theme = in.nextLine();
                        count++;
                    } while (!T.controlTheme(theme));
                    System.out.println();
                    System.out.println("Voici la liste des questions de ce thème :");
                    Q.selectQuestions(theme);
                    System.out.println();
                    System.out.println("Quel est le numéro de la question que vous souhaitez supprimer ?");
                    numeroQuestion = in.nextInt();
                    Q.delQuestion(theme, numeroQuestion);
                    System.out.println();
                    System.out.println("Voici la liste des questions de ce thème après modifications :");
                    Q.selectQuestions(theme);
                    break;

                case 6:
                    int nbJoueurs;

                    System.out.println("Combien de joueurs souhaitez-vous ajouter ? (minimum 4 joueurs !)");
                    nbJoueurs = in.nextInt();
                    J = new Joueurs(nbJoueurs);
                    System.out.println();
                    System.out.println("Voici le tableau des joueurs et leurs états :");
                    J.afficherJoueurs();
                    break;

                case 7:
                    PhaseTrois PTrois = new PhaseTrois();
                    break;

                case 8:
                    sortir();
                    break;

                default:
                    System.out.println("Cette option n'existe pas !");
            }
        } while (choix != 8);

    }

    public static int menuPrincipal() {
        int tmp;

        System.out.println();
        System.out.println("###########################################################");
        System.out.println("              #############################");
        System.out.println("              #       Menu Principal      #");
        System.out.println("              #############################");
        System.out.println();
        System.out.println("1. Afficher les 10 thèmes");
        System.out.println("2. Créer une liste de questions pour chaque thème");
        System.out.println("3. Afficher toutes les questions d'un certain niveau");
        System.out.println("4. Ajouter une question à la liste d'un thème");
        System.out.println("5. Supprimer une question de la liste d'un thème");
        System.out.println("6. Créer le tableau de joueurs et afficher leurs états");
        System.out.println("7. Lancer une partie du jeu avec 4 joueurs");
        System.out.println("8. Quitter le jeu");
        System.out.println("###########################################################");
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