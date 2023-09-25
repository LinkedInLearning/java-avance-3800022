package com.syllab.ventes;

import java.time.Clock;
import java.time.Instant;

public class App {
    public static void main(String[] args) {
        var horloge = Clock.systemUTC();
        var tva = 0.20;
        var article = new Article("Skateboard", 39.90);
            
        article.abandonner(Instant.now(horloge));
        if(!article.estAbandonne()) {
            System.out.println(article);
            System.out.printf("%s : %.2f euros TTC\n", article.nom(), article.prixTTC(tva));
        }
    }
}
