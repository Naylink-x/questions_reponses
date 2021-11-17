package fr.questions_reponses;

public class RC extends Question {
    
    public RC(String theme, int niveau, String question, String reponse, String[] options) {
        super(theme, niveau, question, reponse);
        this.options = options;
    }

    public void addOptions(String x) {
        options[0] = x;
    }
}
