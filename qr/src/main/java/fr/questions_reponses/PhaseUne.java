package fr.questions_reponses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class PhaseUne implements Phase {

    private Scanner in = new Scanner(System.in);
    
    private ArrayList<Joueur> listeParticipants;
    private Questions Q;
    private Themes T;
    private HashMap<String, Questions> listeQuestionList = new HashMap<String, Questions>();
    
    public PhaseUne() {
        T = new Themes();

        String theme = "";
        for (int i=0; i<T.getThemes().size(); i++) {
            theme = T.getTheme(i);
            Q = new Questions(theme);
            listeQuestionList.put(theme, Q);
        }
    }

    public void jouerPhase() {
        Random random = new Random();
        int nb = random.nextInt(10);
        String theme = "";

        for (int j=0; j<listeParticipants.size(); j++) {
            int count = 0;
            if (nb == T.getThemes().size()) nb = 0;
            theme = T.getTheme(nb);
            while (listeQuestionList.get(theme).getQuestionList().get(count).niveau != 1) {
                count++;
            }
            afficherQuestionJoueur(theme, j, count);
            bonneReponse(theme, j, count);
            listeQuestionList.get(theme).getQuestionList().remove(count);
            nb++;
        }
        elimination();
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
        listeParticipants.remove(joueurElimine);
    }

    public void bonneReponse(String t, int p, int q) {
        String reponse = "";

        System.out.println("Quelle est votre réponse ?");
        reponse = in.nextLine();
        if (reponse.equals(listeQuestionList.get(t).getQuestionList().get(q).reponse)) {
            listeParticipants.get(p).setScore(2);
        }
    }

    public void afficherQuestionJoueur(String t, int p, int q) {
        listeParticipants.get(p).afficherJoueur();
        System.out.println("Voici votre question :");
        listeQuestionList.get(t).selectQuestion(q);
    }
    
    public void selectionJoueurs() {
        Joueurs J = new Joueurs();
        listeParticipants = new ArrayList<Joueur>(J.genererParticipants());
    }

    public void gestionIterateur(LinkedList<Object> ll, int nb) {

    }
}
