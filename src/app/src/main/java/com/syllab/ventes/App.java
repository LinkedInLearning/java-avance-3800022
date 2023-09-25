package com.syllab.ventes;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        try
        {
            var tva = 0.20;
         
            // Création du catalogue
            var catalogue = new ArrayList<Article>();

            catalogue.add(new Article("SK02", "Skateboard", 39.90));
            catalogue.add(new Article("CS43", "Casque"    , 19.50));
            catalogue.add(new Article("GP98", "Grip"      , 7.95));

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

            // Parcours du catalogue
            var filtrePrix = new Intervalle<Double>(10.00, 50.00);
            var filtreDate = new Intervalle<Instant>(Instant.MIN, OffsetDateTime.of(2023, 9, 23, 0, 0, 0, 0, ZoneOffset.ofHours(0)).toInstant());
            
            for(var article : catalogue) {
                if( !filtreDate.contient(article.abandonne())
                && filtrePrix.contient(article.prixTTC(tva))) 
                {
                    System.out.printf("%s : %.2f euros TTC\n", article.nom(), article.prixTTC(tva));
                }
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
    public record Intervalle<T extends Comparable<T>>(T min, T max) {
        public boolean contient(T valeur) {
            return this.min().compareTo(valeur) <= 0 && valeur.compareTo(this.max()) <= 0;
        }
    }
}
