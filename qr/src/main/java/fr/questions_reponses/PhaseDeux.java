package fr.questions_reponses;

public class PhaseDeux extends Phases implements Phase {

    private PhaseUne P1;

    public PhaseDeux() {
        super();
        P1 = new PhaseUne();

        this.selectionJoueurs();
        Q = P1.getQ();
        T = P1.getT();
        this.jouerPhase();
    }

    @Override
    public void jouerPhase() {
        String theme = "";
        int elim;

        System.out.println();
        System.out.println();
        System.out.println("##############################");
        System.out.println("# ----- Deuxième phase ----- #");
        System.out.println("##############################");

        for (int j=0; j<2; j++) {
            for (int i=0; i<J.getListeParticipants().size(); i++) {
                if (!J.getListeParticipants().get(i).getEtat().equals("éliminé")) {
                    J.getListeParticipants().get(i).afficherJoueur();
                    int count = 0;
                    theme = super.choisirTheme();
                    System.out.println();
                    while (Q.getListeQuestionList().get(theme).get(count).niveau != 2) {
                        count++;
                    }
                    System.out.println();
                    Q.selectQuestion(theme, count);
                    super.bonneReponse(theme, i, count, 3);
                    Q.getListeQuestionList().get(theme).remove(count);
                    T.getThemes().remove(theme);
                }
            }
        }
        elim = super.elimination();
        super.resultatPhase(2, elim);
    }

    @Override
    public void selectionJoueurs() {
        J = P1.getJ();
    }
}
