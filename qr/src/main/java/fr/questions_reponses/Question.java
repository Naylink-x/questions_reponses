package fr.questions_reponses;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class Question {
    Scanner in = new Scanner(System.in);

    protected static int numero_init = 1;
    protected int numero;
    protected Themes initTheme = new Themes();
    protected String theme;
    protected int niveau;
    protected String type;
    protected String question;
    protected String reponse;
    protected ArrayList<String> options = new ArrayList<String>();
    

    public Question(String theme, int niveau, String question, String reponse, String type, ArrayList<String> options) {
        this.numero = Question.numero_init;
        if (initTheme.controlTheme(theme)) this.theme = theme; // gérer le cas ou controlTheme renvoi false
        this.niveau = niveau;
        this.question = question;
        this.reponse = reponse;
        this.type = type;
        this.options = options;
        Question.numero_init++;
    }

    public Question() {

    }

    // TODO : Serialize method to export questions

    public void exportQuestion(Question Q, Path dest) throws IOException {
        // NOT WORKING
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        try (PrintWriter wr = new PrintWriter(Files.newBufferedWriter(dest))) {
            JsonElement jsonElement = gson.toJsonTree(Q);
            JsonObject questionObject = new JsonObject();
            questionObject.add("questions", jsonElement);
            gson.toJson(questionObject, wr);
        }
    }

    public void afficherQuestion() {
        System.out.print("Thème : " + theme + " , ");
        System.out.print("Difficulté : " + niveau + " , ");
        System.out.println("Type : " + type);
        System.out.print(numero + ". ");
        System.out.println(question);
        if (options.size() != 0)
            for (String option : options) {
                System.out.println(option);
            }
    }

    /* public Question saisieQuestion(String theme, int niveau, String question, String reponse, String type, ArrayList<String> options) {
        return new Question(theme, niveau, question, reponse, type, options);
    } */

    public Question saisieQuestion() {
        Question Q = new Question();

        System.out.println("Quel type de question souhaitez vous créer ? (QCM, VF, RC)");
        type = (in.nextLine());
        switch (type) {
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
