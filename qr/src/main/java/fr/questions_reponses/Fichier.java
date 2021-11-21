package fr.questions_reponses;

import java.io.*;

public class Fichier {
    private ObjectOutputStream ofW;
    private ObjectInputStream ofR;
    private String fileName = "Compte.dat";
    private char mode;

    public boolean open(String s) {
        try {
            mode = s.toUpperCase().charAt(0);
            if (mode == 'R' || mode =='L') 
                ofR = new ObjectInputStream(new FileInputStream(fileName));
            else if (mode == 'W' || mode == 'E')
                ofW = new ObjectOutputStream(new FileOutputStream(fileName));
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    public void write(Object tmp) {
        try {
            if (tmp != null) ofW.writeObject(tmp);
        }
        catch (IOException e) {
            System.out.println(fileName + " : Erreur lors de l'écriture ");
        }
    }

    public Object read() {
        try {
            Object tmp = (Object) ofR.readObject();
            return tmp;
        }
        catch (IOException e) {
            System.out.println(fileName + " : Erreur de lecture ");
        }
        catch (ClassNotFoundException e) {
            System.out.println(fileName + " : n'est pas du bon format ");
        }
        return null;
    }

    public void close() {
        try {
            if (mode == 'R' || mode == 'L') ofR.close();
            else if (mode == 'W' || mode == 'E') ofW.close();
        }
        catch (IOException e) {
            System.out.println(fileName + " : Erreur à la fermeture ");
        }
    }
}
