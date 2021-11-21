package fr.questions_reponses;

import java.util.ArrayList;
import java.util.Scanner;

public class Question {
    Scanner in = new Scanner(System.in);

    protected static int numero_init = 1;
    protected int numero;
    protected String theme;
    protected int niveau;
    protected String type;
    protected String question;
    protected String reponse;
    protected ArrayList<String> options = new ArrayList<String>();

    public Question(int numero, String theme, int niveau, String question, String reponse, String type, ArrayList<String> options) {
        this.numero = Question.numero_init;
        this.theme = theme;
        this.niveau = niveau;
        this.question = question;
        this.reponse = reponse;
        this.type = type;
        this.options = options;
        Question.numero_init++;
    }

    public Question() {
    
    }

    public void afficherQuestion() {
        System.out.print("Thème : " + theme + " , ");
        System.out.print("Difficulté : " + niveau + " , ");
        System.out.println("Type : " + type);
        System.out.print(numero + ". ");
        System.out.println(question);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public Question saisieQuestion() {
        Question Q = new Question();

        System.out.println("Quel type de question souhaitez vous créer ? (QCM, VF, RC)");
        type = (in.nextLine());
        switch(type) {
            case "QCM" :
                Q = new QCM();
                break;
            case "VF" :
                Q = new VF();
                break;
            case "RC" :
                Q = new RC();
                break;
        }
        Q.type = type;
        return Q;
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
