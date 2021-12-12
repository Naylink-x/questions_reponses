package fr.questions_reponses;

import java.util.LinkedList;

public class Questions {
    
    private LinkedList<Question> questionList;

    // TODO : Méthode représentation textuelle de tous les thèmes et de leurs questions

    // TODO : Attribuer des questions à chaque thème sous forme de liste chaînée (entre 5 et 10 par thème) + indicateur de la question sélectionnée

    // TODO : Constructeur 
    public Questions(String theme) {
        Jsonfile json = new Jsonfile();
        questionList = new LinkedList<Question>();
        questionList = json.importQuestions(theme);
        
    }

    public Questions() {

    }

    public void showQuestions() {
        for (Question Q : questionList) {
            System.out.print("Thème : " + Q.theme + " , ");
            System.out.print("Difficulté : " + Q.niveau + " , ");
            System.out.println("Type : " + Q.type);
            System.out.print(Q.numero + ". ");
            System.out.println(Q.question);
            for (String option : Q.options) {
                System.out.println(option);
            }
        }
    }

    /* public LinkedList<Question> importQuestions(String theme) {

        File input = new File("./src/main/resources/qrFile.json");
        
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
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
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Collections.shuffle(questionList);
        return questionList;
    } */

    public void addQuestion(Question Q) {
        questionList.add(Q);
    }
    
    public void delQuestion(int index) {
        questionList.remove(index);
    }

    public void selectQuestion(int index) {
        System.out.print("Thème : " + questionList.get(index).theme + " , ");
        System.out.print("Difficulté : " + questionList.get(index).niveau + " , ");
        System.out.println("Type : " + questionList.get(index).type);
        System.out.print(questionList.get(index).numero + ". ");
        System.out.println(questionList.get(index).question);
        for (String option : questionList.get(index).options) {
            System.out.println(option);
        }
    }

    public LinkedList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(LinkedList<Question> questionList) {
        this.questionList = questionList;
    }
}
