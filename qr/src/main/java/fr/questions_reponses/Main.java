package fr.questions_reponses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) throws IOException {

        Phases P = new Phases();
        P.selectionJoueurs();
        P.premierePhase();
        
        
        /* Themes T = new Themes();
        Random random = new Random();
        int nb = random.nextInt(10);
        int x = 1;
        nb = 8;
        ListIterator<String> itThemes = T.getThemes().listIterator(nb);
        
        if (nb != T.getThemes().size() - 1) {
            while (itThemes.hasNext() && itThemes.nextIndex() != T.getThemes().size() - 1) {
                itThemes.next();
            }
            itThemes = T.getThemes().listIterator(nb);
        }
        if (itThemes.nextIndex() == nb && itThemes.previousIndex() != 0) {
            while (itThemes.hasPrevious()) {
                itThemes.previous();
            }
        } */
        
        /* Questions Q = new Questions();
        Q.importQuestions("Histoire");
        Q.showQuestions(); */


        /* Q = Q.saisieQuestion();
        Q.exportQuestion(Q, Paths.get("qr/src/main/resources/qrFile2.json")); */
        
        //Q.afficherQuestion();

        /*Q = Q.saisieQuestion();
        Q.afficherQuestion();

        Q = Q.saisieQuestion();
        Q.afficherQuestion(); */


        /* File input = new File("qr/src/main/resources/qrFile.json");
        ArrayList<Question> questionsList = new ArrayList<Question>();
        
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();

            JsonArray questions = fileObject.get("questions").getAsJsonArray();
            for (JsonElement questionElement : questions) {
                JsonObject questionObject = questionElement.getAsJsonObject();

                String theme = questionObject.get("theme").getAsString();
                int niveau = questionObject.get("niveau").getAsInt();
                String question = questionObject.get("question").getAsString();
                String reponse = questionObject.get("reponse").getAsString();
                String type = questionObject.get("type").getAsString();

                ArrayList<String> optionsList = new ArrayList<String>();
                JsonArray options = questionObject.get("options").getAsJsonArray();
                for (JsonElement optionElement : options) {

                    String opt = optionElement.getAsString();
                    optionsList.add(opt);
                }

                Question Q = new Question(theme, niveau, question, reponse, type, optionsList);

                questionsList.add(Q);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (Question Q : questionsList) {
            Q.afficherQuestion();
        } */
    }
}
