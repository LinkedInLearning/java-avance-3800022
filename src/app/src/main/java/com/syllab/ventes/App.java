package com.syllab.ventes;

import java.time.Clock;
import java.time.Instant;

public class App {
    public static void main(String[] args) {
        var horloge = Clock.systemUTC();
        var tva = 0.20;
        var article = new Article("Skateboard", 39.90);
            
        try
        {
            article.abandonner(Instant.now(horloge));
            System.out.println(article);
            System.out.printf("%s : %.2f euros TTC\n", article.nom(), article.prixTTC(tva));
        }
        catch(EtatArticleException e) {
            System.err.printf("Mauvaise gestion de l'état de l'article %s.\n", e.article());
        }
        catch(IllegalArgumentException e) {
            System.err.println("Bug non géré.");
            e.printStackTrace();
        }
        finally
        {
            System.out.println("Fin de l'application");
        }
        
        
    }
}
