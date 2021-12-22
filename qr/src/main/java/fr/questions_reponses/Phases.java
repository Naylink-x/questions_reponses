package fr.questions_reponses;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Phases implements Phase {

    private Scanner in = new Scanner(System.in);

    protected Joueurs J = new Joueurs();
    protected Questions Q = new Questions();
    protected Themes T = new Themes();

    public Phases() {

    }

    @Override
    public void jouerPhase() {

    }

    @Override
    public void selectionJoueurs() {
        J.genererParticipants();
    }

    public void eliminerThemes() {
        Random random = new Random();
        int range = 10;

        for (int i=0; i<7; i++) {
            int nb = random.nextInt(range);
            T.getThemes().remove(nb);
            range--;
        }
    }

    public String choisirTheme() {
        int count = 0;
        String selectedTheme = "";

        do {
            if (count != 0) System.out.println("Vous devez choisir un thème présent dans la liste !");
            System.out.println("Choisissez un thème parmi les suivants :");
            T.showAllThemes();
            selectedTheme = in.nextLine();

            count++;
        }  while (!T.controlTheme(selectedTheme));

        return selectedTheme;
    }

    public void elimination() {
        ArrayList<Integer> scoreMinimum = new ArrayList<Integer>();
        int joueurElimine = 0;
        int count = 0;

        for (int i=0; i<J.getListeParticipants().size(); i++) {
            if (!J.getListeParticipants().get(i).getEtat().equals("éliminé")) {
                scoreMinimum.add(J.getListeParticipants().get(i).getScore());
                if (scoreMinimum.size() > 1) {
                    if (scoreMinimum.get(count) < scoreMinimum.get(count - 1)) {
                        joueurElimine = i;
                    }
                }
                count++;
            }
        }
        //System.out.println("Résultats de la premère phase :");
        // TODO: créer classe mère 'Phases' pour pouvoir accéder aux méthodes 'Joueurs'
        //  et transmettre la listeParticipants aux autres phases
        J.getListeParticipants().get(joueurElimine).setEtat("éliminé");

        //J.getListeParticipants().remove(joueurElimine);
    }

    public void bonneReponse(String theme, int participant, int question, int score) {
        String reponse = "";

        System.out.println("Quelle est votre réponse ?");
        reponse = in.nextLine();
        if (reponse.equals(Q.getListeQuestionList().get(theme).get(question).reponse)) {
            J.getListeParticipants().get(participant).setScore(score);
        }
    }

    public Joueurs getJ() {
        return J;
    }

    public Questions getQ() {
        return Q;
    }

    public Themes getT() {
        return T;
    }
}
