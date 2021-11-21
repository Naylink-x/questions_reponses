package fr.questions_reponses;

import java.util.ArrayList;

public class RC extends Question {
    
    public RC(int numero, String theme, int niveau, String question, String reponse, String type, ArrayList<String> options) {
        super(numero, theme, niveau, question, reponse, type, options);
    }

    public RC() {
        super.numero = Question.numero_init;
        Question.numero_init++;
        
        System.out.println("Attribuez un thème à la question : ");
        super.theme = in.nextLine();
        System.out.println("Attribuez un niveau à la question : ");
        super.niveau = in.nextInt();
        in.nextLine();
        System.out.println("Quel est l'intitulé de la question ? ");
        super.question = in.nextLine();
        System.out.println("Quelle est la bonne réponse à la question ? ");
        super.reponse = in.nextLine();
    }

    public void addOptions(String x) {
        
    }
}
