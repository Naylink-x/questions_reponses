package fr.questions_reponses;

import java.util.Random;

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
        int elim;

        System.out.println();
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
            System.out.println();
            Q.selectQuestion(theme, count);
            super.bonneReponse(theme, i, count, 2);
            Q.getListeQuestionList().get(theme).remove(count);
            nb++;
            T.getThemes().remove(theme);
        }
        elim = super.elimination();
        super.resultatPhase(1, elim);
    }

    @Override
    public void selectionJoueurs() {

    }
}
