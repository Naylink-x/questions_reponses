package fr.questions_reponses;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Joueurs {
    
    public static Scanner in = new Scanner(System.in);
    private int nbJoueurs;
    private String nomJoueur;
    private ArrayList<Joueur> listeJoueurs;
    private ArrayList<Joueur> listeParticipants;
    
    public Joueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
        listeJoueurs = new ArrayList<Joueur>(this.nbJoueurs);
        for (int i=0; i<nbJoueurs; i++) {
            System.out.println("Saisissez un nom de joueur : ");
            nomJoueur = in.nextLine();
            listeJoueurs.add(Joueur.saisieJoueur(nomJoueur));
        }
    }

    public Joueurs() {
        String[] listeNoms = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"};

        listeJoueurs = new ArrayList<Joueur>(20);
        for (int i=0; i<20; i++) {
            listeJoueurs.add(Joueur.saisieJoueur(listeNoms[i]));
        }        
    }

    public void afficherJoueurs() {
        for (int i=0; i<listeJoueurs.size(); i++) {
            listeJoueurs.get(i).afficherJoueur();
        }
    } 

    public void afficherRandom() {
        Random random = new Random();
        int nb = random.nextInt(listeJoueurs.size());

        listeJoueurs.get(nb).afficherJoueur();
    }

    public ArrayList<Joueur> genererParticipants() {
        Random random = new Random();
        ArrayList<Integer> listeNb = new ArrayList<Integer>();
        listeParticipants = new ArrayList<Joueur>();

        while (listeNb.size() < 4) {
            boolean estPresent = false;
            int nb = random.nextInt(listeJoueurs.size());
            for (int i=0; i<listeNb.size(); i++) {
                if (listeNb.get(i) == nb) {
                    estPresent = true;
                }
            }
            if(!estPresent) {
                listeNb.add(nb);
            }
        }

        for (int i=0; i<listeNb.size(); i++) {
            listeParticipants.add(listeJoueurs.get(listeNb.get(i)));
            listeParticipants.get(i).setEtat("sélectionné");
        }
        return listeParticipants;
    }

    public void afficherParticipants() {
        for (int i=0; i<listeParticipants.size(); i++) {
            listeParticipants.get(i).afficherJoueur();
        }
    }

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    public ArrayList<Joueur> getListeParticipants() {
        return listeParticipants;
    }

    public void setListeParticipants(ArrayList<Joueur> listeParticipants) {
        this.listeParticipants = listeParticipants;
    }

    
}
