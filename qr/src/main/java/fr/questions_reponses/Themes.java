package fr.questions_reponses;

import java.util.ArrayList;
import java.util.Random;

public class Themes {

    public ArrayList<String> themes = new ArrayList<>();

    public Themes(){

        // TODO : Remplacer ArrayList par HashMap afin d'avoir un indicateur du thème sélectionné ?

        themes.add("Histoire");
        themes.add("Géographie");
        themes.add("Sport");
        themes.add("Science");
        themes.add("Culture générale");
        themes.add("Musique");
        themes.add("Litterature");
        themes.add("Divertissement");
        themes.add("Math");
        themes.add("Logique");
    }

    public void showAllTheme() {
        for (String theme : themes) {
            System.out.println(theme);
        }
    }

    public void showTheme(int i){

        String selectedTheme = themes.get(i);
        System.out.println(i + ". " + selectedTheme);
    }

    public void showThemes(int nbTheme) {

        Random random = new Random();
        ArrayList<Integer> listNb = new ArrayList<>();

        while(listNb.size() <= nbTheme) {
            boolean isSelected = false;
            int nb = random.nextInt(themes.size());

            for (Integer integer : listNb) {

                if (integer == nb) {
                    isSelected = true;
                    break;
                }
            }
            if(!isSelected) {
                listNb.add(nb);
            }
        }
        for(int i = 0; i <= nbTheme; i++){

            int newList = listNb.get(i);
            String SelectedTheme = themes.get(newList);
            System.out.println(newList + ". " +SelectedTheme);
        }
    }
}

