package qr.src.main.java.fr.questions_reponses;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueurs {
    
    public static Scanner in = new Scanner(System.in);
    private int nbJoueurs;
    private String nomJoueur;

    ArrayList<Joueur> listeJoueurs;
    
    public Joueurs(int nbJoueurs) {
        listeJoueurs = new ArrayList<Joueur>(this.nbJoueurs);
        for(int i=0; i<nbJoueurs; i++) {
            System.out.println("Saisissez un nom de joueur : ");
            nomJoueur = in.nextLine();
            listeJoueurs.add(Joueur.saisieJoueur(nomJoueur));
        }
    }

    public void afficherJoueurs() {
        for(int i=0; i<nbJoueurs; i++) {
            listeJoueurs.get(i);
        }
    } 
}
