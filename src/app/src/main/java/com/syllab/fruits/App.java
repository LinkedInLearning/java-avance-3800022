package com.syllab.fruits;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Source : https://fr.wikipedia.org/wiki/Fruit_(alimentation_humaine)
        var fruits = "Citron, Clémentine, Kiwi, Mandarine, Orange, Noix, Poires, Pommes, Châtaignes, Dattes, Fraises, Framboises, Melons, Mirabelles, Mûres, Myrtilles, Pêches, Prunes, Raisins, Coings, Feijoas, Kakis, Abricots, Amandes, Cerises, Brugnons, Cassis, Groseilles, Pastèques";
        var liste = new String[]{};

        Arrays.sort(liste);
        for (var f : liste) {
            System.out.println(f);
        }
        var tri = "";
        var sep = "";

        for(var f : liste) {
            tri += sep + f;
            sep = ", ";
        }
        System.out.println(tri);
    }
}
