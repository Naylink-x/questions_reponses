package fr.questions_reponses;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QCM extends Question {

    Scanner in = new Scanner(System.in);

    public QCM(String theme, int niveau, String question, String reponse, String type, ArrayList<String> options) {
        super(theme, niveau, question, reponse, type, options);
    }

    public QCM() {
        super.numero = Question.numero_init;
        Question.numero_init++;

        String opt1;
        String opt2;
        String opt3;
        int count = 0;
        boolean isInt = true;
        
        do {
            if (count > 0) System.out.println("Ce thème n'existe pas, renseignez un thème qui existe !");
            System.out.println("Attribuez un thème à la question : ");
            super.theme = in.nextLine();
            count++;
        } while (!initTheme.controlTheme(super.theme));
        
        do {
            try {
                System.out.println("Attribuez un niveau à la question : ");
                super.niveau = in.nextInt();
                in.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre");
                isInt = false;
            }
        } while (isInt != true);

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
