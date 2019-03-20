package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "PHP";
        langs[3] = "JS";

        System.out.println("------------------------------------");

        String[] langss = {"Java", "C#", "PHP", "JS"};

        for (int i = 0; i < langss.length; i++) {
            System.out.println("Я хочу выучить " + langss[i]);
        }

        System.out.println("------------------------------------");

        //Коллекции
        for (String l : langs) {
            System.out.println("Я хочу выучить " + l);
        }

        System.out.println("------------------------------------");

        List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("C#");
        languages.add("PHP");
        languages.add("JS");

        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }

        System.out.println("------------------------------------");

        List<String> languagess = Arrays.asList("Java", "C#", "PHP", "JS");

        for (String l : languagess) {
            System.out.println("Я хочу выучить " + l);
        }

        /*for (int i =0; i < languagess.size(); i++) {
            System.out.println("Я хочу выучить " + languagess.get(i));
        }*/

    }
}
