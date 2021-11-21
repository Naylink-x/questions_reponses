package fr.questions_reponses;

import java.util.ArrayList;

public class VF extends Question {

    public VF(int numero, String theme, int niveau, String question, String reponse, String type, ArrayList<String> options) {
        super(numero, theme, niveau, question, reponse, type, options);
    }

    public VF() {
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

        super.options.add("Vrai");
        super.options.add("Faux");
    }

    public void addOptions() {

    }
}
