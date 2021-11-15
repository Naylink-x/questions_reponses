package qr.src.main.java.fr.questions_reponses;

public class Joueur {
    
    private static int numero_init = 100;
    private String nom;
    private int numero;
    private int score;
    private String etat;

    public Joueur(String nom) {
        this.numero = Joueur.numero_init;
        this.nom = nom;
        this.score = 0;
        this.etat = "en attente";
        Joueur.numero_init += 10;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void afficherJoueur() {
        System.out.println(this.nom);
        System.out.println("Numéro : " + this.numero);
        System.out.println("Score : " + this.score);
        System.out.println("Etat : " + this.etat);
    }

    public static Joueur saisieJoueur(String nom) {
        return new Joueur(nom);
    }

}
