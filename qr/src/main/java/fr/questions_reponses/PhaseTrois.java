package fr.questions_reponses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PhaseTrois extends Phases implements Phase {

    private PhaseDeux P2;
    private int nb;

    public PhaseTrois() {
        super();
        P2 = new PhaseDeux();

        this.selectionJoueurs();
        Q = P2.getQ();
        T = P2.getT();
        this.jouerPhase();
    }

    @Override
    public void jouerPhase() {
        Random random = new Random();
        String theme = "";

        System.out.println();
        System.out.println("##############################");
        System.out.println("# ----- Troisième phase ----- #");
        System.out.println("##############################");

        for (int i=0; i<J.getListeParticipants().size(); i++) {
            if (!J.getListeParticipants().get(i).getEtat().equals("éliminé")) {
                T = new Themes();
                super.eliminerThemes();
                nb = random.nextInt(3);

                J.getListeParticipants().get(i).afficherJoueur();
                theme = T.getTheme(nb);
                if (nb == T.getThemes().size()) nb = 0;
                int count = 0;

                while (Q.getListeQuestionList().get(theme).get(count).niveau != 3) {
                    count++;
                }
                Q.selectQuestion(theme, count);
                super.bonneReponse(theme, i, count, 5);
                Q.getListeQuestionList().get(theme).remove(count);
            }
        }
        super.elimination();
        //J.getListeParticipants().get(0).setEtat("super gagnant");
    }

    @Override
    public void selectionJoueurs() {
        J = P2.getJ();
    }
}
