package fr.questions_reponses;

public class Question {
    private static int numero_init = 1;
    protected int numero;
    protected String theme;
    protected int niveau;
    protected String type;
    protected String question;
    protected String reponse;
    protected String[] options;

    public Question(String theme, int niveau, String question, String reponse) {
        this.numero = Question.numero_init;
        this.theme = theme;
        this.niveau = niveau;
        this.question = question;
        this.reponse = reponse;
        Question.numero_init++;
    }

    public Question() {

    }

    public void afficherQuestion() {
        System.out.print("Thème : " + theme + " , ");
        System.out.println("Difficulté : " + niveau);
        System.out.print(numero + ", ");
        System.out.println(question);
        for (int i=0; i<options.length; i++) {
            System.out.println(options[i]);
        }
    }

    public void saisieQuestion(String type, String theme, int niveau, String question, String reponse, String options[]) {
        switch(type) {
            case "QCM" :
                new QCM(theme, niveau, question, reponse, options);
                break;
            case "VF" :
                new VF(theme, niveau, question, reponse, options);
                break;
            case "RC" :
                new RC(theme, niveau, question, reponse, options);
                break;
        }
    }
    
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}
