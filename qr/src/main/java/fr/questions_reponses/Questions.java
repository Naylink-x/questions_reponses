package fr.questions_reponses;

import java.util.LinkedList;

public class Questions {
    
    private LinkedList<Question> questionList;

    // TODO : Méthode représentation textuelle de tous les thèmes et de leurs questions

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
