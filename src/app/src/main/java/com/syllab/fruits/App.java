package com.syllab.fruits;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Source : https://fr.wikipedia.org/wiki/Fruit_(alimentation_humaine)
        var fruits = "Citron, Clémentine, Kiwi, Mandarine, Orange, Noix, Poires, Pommes, Châtaignes, Dattes, Fraises, Framboises, Melons, Mirabelles, Mûres, Myrtilles, Pêches, Prunes, Raisins, Coings, Feijoas, Kakis, Abricots, Amandes, Cerises, Brugnons, Cassis, Groseilles, Pastèques";
        var liste = fruits.split(", ");

        Arrays.sort(liste);
        for (var f : liste) {
            System.out.println(f.toUpperCase());
        }
        var tri = new StringBuilder();
        var sep = "";

        for(var f : liste) {
            tri.append(sep);
            tri.append(f);
            sep = ", ";
        }
        System.out.println(tri.toString());
    }
}
