package com.syllab.ventes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        try
        {
            // Création du catalogue
            var catalogue = new ArrayList<Article>();

            catalogue.add(new Article("SK02", "Skateboard", 39.90, new String[]{ "bleu", "rouge" }));
            catalogue.add(new Article("CS43", "Casque"    , 19.50, new String[]{ "rouge", "vert" }));
            catalogue.add(new Article("GP98", "Grip"      , 7.95));

            catalogue.stream()
                .filter(a -> !a.estAbandonne())
                .sorted((a, b) -> a.nom().compareTo(b.nom()))
                .map(a -> String.format("[%s] %s", a.ref(), a.nom()))
                .forEach(System.out::println);
            
            // Test 
                if(catalogue.stream().anyMatch(a-> a.prixHt() < 10)) {
                    System.out.println("Il existe au moins 1 produit à moins de 10€.");
                }
                        
            // Parcours en profondeur 
                System.out.printf(
                    "Variations : %s\n", 
                    catalogue.stream()
                    .flatMap(a -> Arrays.stream(a.variations()))
                    .distinct()
                    .sorted()
                    .collect(Collectors.joining(", "))               
                );
                        
            // Recherche par référence CS43
            var articlesParRef = catalogue.stream().collect(
                Collectors.toMap(a->a.ref(), Function.identity())
            );
            var rechercheRef = "CS43";

            if(articlesParRef.containsKey(rechercheRef)) {
                System.out.printf(
                    "Article %s trouvé au prix de %.2f e HT !\n",
                    rechercheRef,
                    articlesParRef.get(rechercheRef).prixHt()
                );
            }
        }
        catch(IllegalStateException e) {
            System.err.printf("Mauvaise gestion de l'état d'un article.\n");
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
