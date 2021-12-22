package fr.questions_reponses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class PhaseUne extends Phases implements Phase {

    private int nb;
    
    public PhaseUne() {
        super();
        super.selectionJoueurs();

        this.jouerPhase();
    }

    @Override
    public void jouerPhase() {
        Random random = new Random();
        nb = random.nextInt(10);
        String theme = "";

        System.out.println();
        System.out.println("##############################");
        System.out.println("# ----- Première phase ----- #");
        System.out.println("##############################");

        for (int i=0; i<J.getListeParticipants().size(); i++) {
            J.getListeParticipants().get(i).afficherJoueur();
            int count = 0;
            if (nb >= T.getThemes().size()) nb = 0;
            theme = T.getTheme(nb);
            while (Q.getListeQuestionList().get(theme).get(count).niveau != 1) {
                count++;
            }
            Q.selectQuestion(theme, count);
            super.bonneReponse(theme, i, count, 2);
            Q.getListeQuestionList().get(theme).remove(count);
            nb++;
            T.getThemes().remove(theme);
        }
        super.elimination();
    }

    @Override
    public void selectionJoueurs() {

    }
}
