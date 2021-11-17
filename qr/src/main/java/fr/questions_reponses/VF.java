package fr.questions_reponses;

public class VF extends Question {

    public VF(String theme, int niveau, String question, String reponse, String[] options) {
        super(theme, niveau, question, reponse);
        this.options = options;
    }

    public void addOptions() {
        options[0] = "vrai";
        options[1] = "faux";
    }
}
