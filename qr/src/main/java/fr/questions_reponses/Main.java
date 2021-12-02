package fr.questions_reponses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
    public static void main(String[] args) throws IOException {
        
        //Joueurs J = new Joueurs();

        

        // J.afficherJoueurs();
        // J.afficherRandom();

        // J.genererParticipants();
        // J.afficherParticipants();

        /* String [] a={"A","B","C"};
        Question Q=new Question();
        Question X = new QCM();
        Q= Q.saisieQuestion("QCM","Histoire",3,"A ou B ou C", "A", a);
        
        X.addOptions("A","B","C");

        Questions Q = new Questions("histoire", 3, "Quelle est la réponse à ce qcm ?", "A"); */

        /* String choix = "rc";

        if(choix.equals("qcm")){
            Q.addOptionsQCM("a", "b", "c");

        }else if(choix.equals("vf")) {
            Q.addOptionsVF();
        }else if(choix.equals("rc")){
            Q.addOptionsRC("c'est ça la réponse ?");
        }else{
            System.out.println("Veuillez entrer un type valide");
        }

        Q.afficherQuestion(); */

        Questions Q = new Questions();
        Q.importQuestions("Histoire");
        Q.showQuestions();
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
