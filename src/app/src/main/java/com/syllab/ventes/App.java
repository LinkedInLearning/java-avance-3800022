package com.syllab.ventes;

public class App {
    public static void main(String[] args) {
        var article = new Article("Skateboard", 39.90);
    
        System.out.println(article);
        System.out.printf("%s : %.2f euros TTC", article.nom(), article.prixTTC());
    }
}
