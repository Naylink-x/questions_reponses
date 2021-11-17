package fr.questions_reponses;

public class QCM extends Question {

    public QCM(String theme, int niveau, String question, String reponse, String[] options) {
        super(theme, niveau, question, reponse);
        super.options = options;
    }

    public void addOptions(String x, String y, String z) {
        super.options[0] = x;
        super.options[1] = y;
        super.options[2] = z;
    }
}
