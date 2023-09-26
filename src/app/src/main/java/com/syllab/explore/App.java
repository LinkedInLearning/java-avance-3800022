package com.syllab.explore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try(var contenu = Files.newDirectoryStream(Path.of("."))) {
            var stats = new StringBuilder();

            contenu.forEach(p -> {
                if(!Files.isDirectory(p)) {
                    stats.append(p.getFileName());
                    try {
                        stats.append(lireFichierTexte(p));  
                    }
                    catch (IOException e) {
                        try {
                            stats.append(lireFichierBinaire(p));
                        }
                        catch(IOException eBin) {
                            stats.append(String.format(" : %s.\n", eBin.getMessage()));
                        }
                    }
                }
            });
            // Ecrire le contenu de stats.toString() dans ./stats.txt
            System.out.println(stats.toString());
        }
        catch(IOException e) {
            System.err.print("Impossible de parcourir le répertoire courant : ");
            System.err.println(e.getMessage());
        }
    }
    public static String lireFichierTexte(Path p) throws IOException {
        var lines = new ArrayList<String>();

        return String.format(
            " : %d lignes dont %d contiennent le mot 'java'.\n", 
            lines.size(),
            lines.stream()
                .filter(l -> l.toLowerCase().contains("java"))
                .count()
        );
    }
    public static String lireFichierBinaire(Path p) throws IOException {
        var octets = new byte[] {};

        if(octets[0]==(byte)0xff && octets[1]==(byte)0xd8) {
            return String.format(" : Fichier JPEG version %d.%d\n", octets[11], octets[12]);
        }
        else {
            return "Format inconnu.\n";
        }
    }
}
