package com.syllab.ventes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class App {
    private static volatile int comparaisons = 0; 
    public static void main(String[] args) {
        try
        {
            // Création du catalogue
            var catalogue = new ArrayList<Article>();

            catalogue.add(new Article("SK02", "Skateboard", 39.90));
            catalogue.add(new Article("CS43", "Casque"    , 19.50));
            catalogue.add(new Article("GP98", "Grip"      , 7.95));

            var ordre = -1;

            catalogue.sort((a, b) -> { 
                comparaisons++; 
                return ordre * a.nom().compareTo(b.nom());
            });
            System.out.printf("Le tri a effectué %d comparaisons.\n", comparaisons);

            System.out.println(Arrays.toString(catalogue.toArray()));

            // Recherche par référence CS43
            var articlesParRef = new HashMap<String, Article>();
        
            for(var article : catalogue) {
                articlesParRef.put(article.ref(), article);
            }          

            var rechercheRef = "CS43";

            if(articlesParRef.containsKey(rechercheRef)) {
                System.out.printf(
                    "Article %s trouvé au prix de %.2f e HT !\n",
                    rechercheRef,
                    articlesParRef.get(rechercheRef).prixHt()
                );
            }
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
