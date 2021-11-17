package fr.questions_reponses;

public class Main {
    public static void main(String[] args) {
        
        Joueurs J = new Joueurs();

        

        // J.afficherJoueurs();
        // J.afficherRandom();

        // J.genererParticipants();
        // J.afficherParticipants();

        String [] a={"A","B","C"};
        Question Q=new Question();
        Q= Q.saisieQuestion("QCM","Histoire",3,"A ou B ou C", "A", a);
        
        Q.addOptions("A","B","C");
        
    }
}
