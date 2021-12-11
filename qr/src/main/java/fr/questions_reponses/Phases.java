package fr.questions_reponses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Phases implements Phase {

    private ArrayList<Joueur> listeParticipants;
    private Questions Q = new Questions();
    private ListIterator<Question> itQuestions;
    private Themes T = new Themes();
    private ListIterator<String> itThemes;
    
    public Phases() {
        
    }

    public void premierePhase() {
        /* Random random = new Random();
        int nb = random.nextInt(10); */
        int count = 0;

        for (int i=0; i<T.getThemes().size(); i++) {
            String theme = T.getTheme(i);
            itThemes = T.getThemes().listIterator(i);
            itThemes.next();
            Q.importQuestions("Histoire");
            itQuestions = Q.getQuestionList().listIterator();
            //itQuestions.next();
        
            for (int j=0; j<listeParticipants.size(); j++) {
                while (Q.getQuestionList().get(count).niveau != 1) {
                    //itQuestions.next();
                    count++;
                }
                count++;
                listeParticipants.get(j).afficherJoueur();
                Q.selectQuestion(count);
            }
        }
    }

    public void jouerPhase() {

    }
    
    public void selectionJoueurs() {
        Joueurs J = new Joueurs();
        listeParticipants = new ArrayList<Joueur>(J.genererParticipants());
    }

    public void gestionIterateur(LinkedList<Object> ll, int nb) {

    }
}
