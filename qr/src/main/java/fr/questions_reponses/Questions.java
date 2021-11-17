package fr.questions_reponses;

public class Questions {
    private String theme;
    private int niveau;
    private String type;
    private String question;
    private String reponse;
    private int choix;

    public Questions(String theme, int niveau, String type) {
        this.theme = theme;
        this.niveau = niveau;
        this.type = type;
    }
}
