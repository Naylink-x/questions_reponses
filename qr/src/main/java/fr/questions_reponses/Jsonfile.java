package fr.questions_reponses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Jsonfile {

    private LinkedList<Question> questionList;

    public Jsonfile() {
        questionList = new LinkedList<Question>();

    }

    public LinkedList<Question> importQuestions(String theme) {
        File input = new File("./src/main/resources/qrFile.json");
        
        try {
            Reader reader = new InputStreamReader(new FileInputStream(input), StandardCharsets.UTF_8);
            JsonElement fileElement = JsonParser.parseReader(reader);
            JsonObject fileObject = fileElement.getAsJsonObject();

            JsonArray questions = fileObject.get("questions").getAsJsonArray();
            for (JsonElement questionElement : questions) {
                JsonObject questionObject = questionElement.getAsJsonObject();

                String themeImport = questionObject.get("theme").getAsString();
                if (themeImport.equals(theme)) {
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

                    Question Q = new Question(themeImport, niveau, question, reponse, type, optionsList);

                    questionList.add(Q);
                }
            }
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Collections.shuffle(questionList);

        return questionList;
    }

    public LinkedList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(LinkedList<Question> questionList) {
        this.questionList = questionList;
    }

    

}