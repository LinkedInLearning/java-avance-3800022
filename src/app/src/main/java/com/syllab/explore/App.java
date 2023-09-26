package com.syllab.explore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.BufferedInputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try(var contenu = Files.newDirectoryStream(Path.of("."));
            var fluxSortie = Files.newBufferedWriter(Path.of("./stats.txt"), StandardOpenOption.CREATE)) {
            
            contenu.forEach(p -> {
                if(!Files.isDirectory(p)) {
                    try {
                        fluxSortie.write(p.getFileName().toString());
                        try {
                            fluxSortie.write(lireFichierTexte(p));  
                        }
                        catch (IOException e) {
                            try {
                                fluxSortie.write(lireFichierBinaire(p));
                            }
                            catch(IOException eBin) {
                                fluxSortie.write(String.format(" : %s.\n", eBin.getMessage()));
                            }
                        }
                    }
                    catch(IOException e) {
                        System.err.printf("Impossible d'écrire la ligne pour %s.", p);
                    }
                }
            });
        }
        catch(IOException e) {
            System.err.print("Impossible de parcourir le répertoire courant : ");
            System.err.println(e.getMessage());
        }
    }
    public static String lireFichierTexte(Path p) throws IOException {
        try(var fluxTexte = Files.newBufferedReader(p)) {
            int nlignes, njava;
            String line;
        
            for(nlignes = njava = 0; (null != (line = fluxTexte.readLine())); nlignes++) {
                if(line.toLowerCase().contains("java")) {
                    njava++;
                }
            }
            return String.format(" : %d lignes dont %d contiennent le mot 'java'.\n", nlignes, njava);
        }
    }
    public static String lireFichierBinaire(Path p) throws IOException {
        try(var fluxBinaire = Files.newInputStream(p); 
            var buf = new BufferedInputStream(fluxBinaire, 13))
        {
            var octets = buf.readNBytes(13);

            if(octets[0]==(byte)0xff && octets[1]==(byte)0xd8) {
                return String.format(" : Fichier JPEG version %d.%d\n", octets[11], octets[12]);
            }
            else {
                return "Format inconnu.\n";
            }
        }
    }
}
