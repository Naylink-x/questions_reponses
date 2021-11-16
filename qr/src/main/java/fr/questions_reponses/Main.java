package fr.questions_reponses;

public class Main {
    public static void main(String[] args) {
        
        Joueurs J = new Joueurs();

        // J.afficherJoueurs();
        // J.afficherRandom();

        J.genererParticipants();
        J.afficherParticipants();
    }
}
