package com.syllab.citations;

import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        var texte = "\"Il y a 2 sortes d'amour : l'amour insatisfait, qui vous rend odieux, l'amour satisfait, qui vous rend idiot.\" Colette (1873-1954)";

        // "[A-Z].*\." \w+ \([-0-9]+\)

        /* Valider
        var citation = Pattern.compile("\"[A-Z].*\\.\" \\w+ \\([-0-9]+\\)");
        if(citation.matcher(texte).matches()) {
            System.out.println("C'est une citation.");
        }
        else {
            System.out.println("Ce texte ne semble pas être une citation.");
        }
        */

        /* Trouver
        var nombre = Pattern.compile("\\d+");
        var occurenceNombre = nombre.matcher(texte);
        var compteur = 0;

        while(occurenceNombre.find()) {
            compteur++;
        }
        System.out.printf("%d nombres ont été trouvés.\n", compteur);
        */

        /* Extraire
        var construction = Pattern.compile("l'amour (\\w+), qui vous rend (\\w+)");
        var occurence = construction.matcher(texte);

        while(occurence.find()) {
            System.out.printf(
                "%s : %s/%s.\n", 
                occurence.group(0),
                occurence.group(1),
                occurence.group(2)
            );
        }
        */
    }
}
