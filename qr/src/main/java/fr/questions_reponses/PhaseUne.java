package fr.questions_reponses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class PhaseUne implements Phase {

    private Scanner in = new Scanner(System.in);
    
    private ArrayList<Joueur> listeParticipants;
    private Joueurs J;
    private Questions Q;
    private Themes T = new Themes();
    private HashMap<String, Questions> listeQuestionList = new HashMap<String, Questions>();
    private int nb;
    
    public PhaseUne() {
        this.selectionJoueurs();
        this.genererListeQuestionList();
        this.jouerPhase();
    }

    public void jouerPhase() {
        Random random = new Random();
        nb = random.nextInt(10);
        String theme = "";

        System.out.println("----- Première phase -----");
        for (int i=0; i<listeParticipants.size(); i++) {
            listeParticipants.get(i).afficherJoueur();
            int count = 0;
            if (nb >= T.getThemes().size()) nb = 0;
            theme = T.getTheme(nb);
            while (listeQuestionList.get(theme).getQuestionList().get(count).niveau != 1) {
                count++;
            }
            afficherQuestionJoueur(theme, i, count);
            bonneReponse(theme, i, count);
            listeQuestionList.get(theme).getQuestionList().remove(count);
            nb++;
            T.getThemes().remove(theme);
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
        //System.out.println("Résultats de la premère phase :");
        // TODO: créer classe mère 'Phases' pour pouvoir accéder aux méthodes 'Joueurs'
        //  et transmettre la listeParticipants aux autres phases
        listeParticipants.get(joueurElimine).setEtat("éliminé");

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
        System.out.println("Voici votre question :");
        listeQuestionList.get(t).selectQuestion(q);
    }
    
    public void selectionJoueurs() {
        J = new Joueurs();
        listeParticipants = new ArrayList<Joueur>(J.genererParticipants());
    }

    public void genererListeQuestionList() {
        String theme = "";
        for (int i=0; i<T.getThemes().size(); i++) {
            theme = T.getTheme(i);
            Q = new Questions(theme);
            listeQuestionList.put(theme, Q);
        }
    }

    public HashMap<String, Questions> getListeQuestionList() {
        return listeQuestionList;
    }

    public void setListeQuestionList(HashMap<String, Questions> listeQuestionList) {
        this.listeQuestionList = listeQuestionList;
    }

    public ArrayList<Joueur> getListeParticipants() {
        return listeParticipants;
    }

    public void setListeParticipants(ArrayList<Joueur> listeParticipants) {
        this.listeParticipants = listeParticipants;
    }

    public Themes getT() {
        return T;
    }
}
