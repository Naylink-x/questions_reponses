package fr.questions_reponses;

public class Main {
    public static void main(String[] args) {
        
        //Joueurs J = new Joueurs();

        

        // J.afficherJoueurs();
        // J.afficherRandom();

        // J.genererParticipants();
        // J.afficherParticipants();

        /* String [] a={"A","B","C"};
        Question Q=new Question();
        Question X = new QCM();
        Q= Q.saisieQuestion("QCM","Histoire",3,"A ou B ou C", "A", a);
        
        X.addOptions("A","B","C");

        Questions Q = new Questions("histoire", 3, "Quelle est la réponse à ce qcm ?", "A"); */

        /* String choix = "rc";

        if(choix.equals("qcm")){
            Q.addOptionsQCM("a", "b", "c");

        }else if(choix.equals("vf")) {
            Q.addOptionsVF();
        }else if(choix.equals("rc")){
            Q.addOptionsRC("c'est ça la réponse ?");
        }else{
            System.out.println("Veuillez entrer un type valide");
        }

        Q.afficherQuestion(); */

        Question Q = new Question();
        Q = Q.saisieQuestion();
        Q.afficherQuestion();

        Q = Q.saisieQuestion();
        Q.afficherQuestion();

        Q = Q.saisieQuestion();
        Q.afficherQuestion();
        
    }
}
