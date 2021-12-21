package fr.questions_reponses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhaseDeux implements Phase {

    private Scanner in = new Scanner(System.in);

    private ArrayList<Joueur> listeParticipants;
    private Questions Q;
    private Themes T;
    private HashMap<String, Questions> listeQuestionList;
    private PhaseUne P1;

    public PhaseDeux() {
        P1 = new PhaseUne();

        this.T = P1.getT();
        //this.nb = P1.getNb();
        this.selectionJoueurs();
        this.recupererListeQuestionList();
        this.jouerPhase();
    }

    @Override
    public void jouerPhase() {
        String theme = "";

        System.out.println("----- Deuxième phase -----");
        for (int j=0; j<2; j++) {
            for (int i=0; i<listeParticipants.size(); i++) {
                listeParticipants.get(i).afficherJoueur();
                int count = 0;
                theme = choisirTheme();
                while (listeQuestionList.get(theme).getQuestionList().get(count).niveau != 2) {
                    count++;
                }
                afficherQuestionJoueur(theme, i, count);
                bonneReponse(theme, i, count);
                listeQuestionList.get(theme).getQuestionList().remove(count);
                T.getThemes().remove(theme);
            }
        }
        elimination();
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

        for (int i=0; i<listeParticipants.size(); i++) {
            scoreMinimum.add(listeParticipants.get(i).getScore());
            if (scoreMinimum.size() > 1) {
                if (scoreMinimum.get(i) < scoreMinimum.get(i-1)) {
                    joueurElimine = i;
                }
            }
        }
        listeParticipants.get(joueurElimine).setEtat("éliminé");
        listeParticipants.remove(joueurElimine);
    }

    public void bonneReponse(String t, int p, int q) {
        String reponse = "";

        System.out.println("Quelle est votre réponse ?");
        reponse = in.nextLine();
        if (reponse.equals(listeQuestionList.get(t).getQuestionList().get(q).reponse)) {
            listeParticipants.get(p).setScore(3);
        }
    }

    public void afficherQuestionJoueur(String t, int p, int q) {
        System.out.println("Voici votre question :");
        listeQuestionList.get(t).selectQuestion(q);
    }

    public void recupererListeQuestionList() {
        listeQuestionList = P1.getListeQuestionList();
    }

    @Override
    public void selectionJoueurs() {
        listeParticipants = P1.getListeParticipants();
    }

    public ArrayList<Joueur> getListeParticipants() {
        return listeParticipants;
    }

    public HashMap<String, Questions> getListeQuestionList() {
        return listeQuestionList;
    }

    public Themes getT() {
        return T;
    }
}
