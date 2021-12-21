package fr.questions_reponses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PhaseTrois implements Phase {

    private Scanner in = new Scanner(System.in);

    private ArrayList<Joueur> listeParticipants;
    private Questions Q;
    private Themes T;
    private HashMap<String, Questions> listeQuestionList;
    private PhaseDeux P2;
    private int nb;

    public PhaseTrois() {
        P2 = new PhaseDeux();

        //this.nb = P2.getNb();
        this.selectionJoueurs();
        this.recupererListeQuestionList();
        this.jouerPhase();
    }

    @Override
    public void jouerPhase() {
        Random random = new Random();
        String theme = "";

        System.out.println("----- Troisième phase -----");

        for (int i=0; i<listeParticipants.size(); i++) {
            T = new Themes();
            choisirTheme();
            nb = random.nextInt(3);

            listeParticipants.get(i).afficherJoueur();
            theme = T.getTheme(nb);
            if (nb == T.getThemes().size()) nb = 0;
            int count = 0;

            while (listeQuestionList.get(theme).getQuestionList().get(count).niveau != 3) {
                count++;
            }
            afficherQuestionJoueur(theme, i, count);
            bonneReponse(theme, i, count);
            listeQuestionList.get(theme).getQuestionList().remove(count);
        }
        elimination();
        listeParticipants.get(0).setEtat("super gagnant");
    }

    public void choisirTheme() {
        Random random = new Random();
        int range = 10;

        for (int i=0; i<7; i++) {
            nb = random.nextInt(range);
            T.getThemes().remove(nb);
            range--;
        }
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
        listeParticipants.get(joueurElimine).setEtat("gagnant");
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

    @Override
    public void selectionJoueurs() {
        listeParticipants = P2.getListeParticipants();
    }

    public void recupererListeQuestionList() {
        listeQuestionList = P2.getListeQuestionList();
    }
}
