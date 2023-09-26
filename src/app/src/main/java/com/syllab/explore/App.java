package com.syllab.explore;

public class App {
    public static void main(String[] args) {
        try {
            // Création du répertoire ./backup
            
            // Pour chaque fichier du répertoire courant :
            // - Lancer la copie
                System.out.printf("Copie de '%s'");
                try {
                    System.out.printf(" (%d o)");
                            
                    System.out.println(" : succès");  
                }
                catch (Exception e) {
                    System.out.printf(" : Échec (%s)\n", e.getMessage());
                }
        }
        catch(Exception e) {
            System.err.print("Impossible de créer le répertoire de backup dans le répertoire courant : ");
            System.err.println(e.getMessage());
        }
    }
}
