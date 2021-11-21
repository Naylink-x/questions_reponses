package fr.questions_reponses;

import java.util.ArrayList;
import java.util.Scanner;

public class QCM extends Question {

    Scanner in = new Scanner(System.in);
    
    //protected ArrayList<String> options;

    public QCM(int numero, String theme, int niveau, String question, String reponse, String type, ArrayList<String> options) {
        super(numero, theme, niveau, question, reponse, type, options);
    }

    public QCM() {
        super.numero = Question.numero_init;
        Question.numero_init++;

        String opt1;
        String opt2;
        String opt3;
        
        System.out.println("Attribuez un thème à la question : ");
        super.theme = in.nextLine();
        System.out.println("Attribuez un niveau à la question : ");
        super.niveau = in.nextInt();
        in.nextLine();
        System.out.println("Quel est l'intitulé de la question ? ");
        super.question = in.nextLine();
        System.out.println("Quelle est la bonne réponse à la question ? ");
        super.reponse = in.nextLine();
        System.out.println("Quelle est la première option de réponse ? ");
        opt1 = in.nextLine();
        System.out.println("Quelle est la deuxième option de réponse ? ");
        opt2 = in.nextLine();
        System.out.println("Quelle est la troisième option de réponse ? ");
        opt3 = in.nextLine();

        super.options.add(opt1);
        super.options.add(opt2);
        super.options.add(opt3);
    }
}
