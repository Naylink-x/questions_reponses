package fr.questions_reponses;

import java.util.HashMap;
import java.util.LinkedList;

public class Questions {
    
    private LinkedList<Question> questionList;
    private Themes T;
    private HashMap<String, LinkedList<Question>> listeQuestionList = new HashMap<String, LinkedList<Question>>();

    // TODO : Méthode représentation textuelle de tous les thèmes et de leurs questions

    public Questions(String theme) {
        Jsonfile json = new Jsonfile();
        questionList = new LinkedList<Question>();
        questionList = json.importQuestions(theme);
        
    }

    public Questions() {
        String theme = "";
        T = new Themes();
        questionList = new LinkedList<Question>();

        for (int i=0; i<T.getThemes().size(); i++) {
            Jsonfile json = new Jsonfile();
            theme = T.getTheme(i);
            questionList = json.importQuestions(theme);
            listeQuestionList.put(theme, questionList);
        }
    }

    public void showAll() {
        for (String theme : listeQuestionList.keySet()) {
            System.out.println();
            System.out.println("-----------------");
            System.out.println(theme);
            System.out.println("-----------------");
            System.out.println();
            for (Question question : listeQuestionList.get(theme)) {
                question.afficherQuestion();
            }
        }
    }

    public void selectQuestions(String theme) {
        for (Question Q : listeQuestionList.get(theme)) {
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

    public void addQuestion(String theme, Question Q) {
        listeQuestionList.get(theme).add(Q);
    }
    
    public void delQuestion(String theme, int index) {
        listeQuestionList.get(theme).remove(index);
    }

    //TODO : voir pour remplacer cette méthode par accès à la méthode afficherQuestion() de la classe Question
    public void selectQuestion(String theme, int index) {
        System.out.print("Thème : " + listeQuestionList.get(theme).get(index).theme + " , ");
        System.out.print("Difficulté : " + listeQuestionList.get(theme).get(index).niveau + " , ");
        System.out.println("Type : " + listeQuestionList.get(theme).get(index).type);
        System.out.print(listeQuestionList.get(theme).get(index).numero + ". ");
        System.out.println(listeQuestionList.get(theme).get(index).question);
        for (String option : listeQuestionList.get(theme).get(index).options) {
            System.out.println(option);
        }
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

    public HashMap<String, LinkedList<Question>> getListeQuestionList() {
        return listeQuestionList;
    }

    public void setListeQuestionList(HashMap<String, LinkedList<Question>> listeQuestionList) {
        this.listeQuestionList = listeQuestionList;
    }
}
