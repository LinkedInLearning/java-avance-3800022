package com.syllab.explore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            // Création du répertoire ./backup
            var dest = Files.createDirectory(Path.of("./backup"));

            // Pour chaque fichier du répertoire courant :
            try(var contenu = Files.newDirectoryStream(Path.of("."))) {
                contenu.forEach(p -> {
                    if(!Files.isDirectory(p)) {
                        // - Lancer la copie
                        System.out.printf("Copie de '%s'", p.toAbsolutePath());
                        try {
                            System.out.printf(" (%d o)", Files.size(p));
                            Files.copy(p, dest.resolve(p.getFileName()));               
                            System.out.println(" : succès");  
                        }
                        catch (IOException e) {
                            System.out.printf(" : Échec (%s)\n", e.getMessage());
                        }
                    }
                });
            }
        }
        catch(IOException e) {
            System.err.print("Impossible de créer le répertoire de backup dans le répertoire courant : ");
            System.err.println(e.getMessage());
        }
    }
}
