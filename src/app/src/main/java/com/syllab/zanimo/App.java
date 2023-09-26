package com.syllab.zanimo;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        var animalerie = new Animalerie(new Animal[]{
            new Animal(1, "Rex"  , Statut.DISPONIBLE, new String[]{ "https://pixabay.com/photos/cocker-spaniel-dog-pet-puppy-3981587/", "https://pixabay.com/photos/dogs-cocker-spaniel-spaniel-dog-4716741/" }),
            new Animal(2, "Felix", Statut.VENDU     , new String[]{ "https://pixabay.com/photos/cat-young-animal-kitten-gray-cat-2083492/"})
        });
        var cheminBin = Path.of("./liste.bin");

        // Sérialisation
        try(var out = Files.newOutputStream(cheminBin); 
            var serialiseur = new ObjectOutputStream(out))
        {
            serialiseur.writeObject(animalerie);
        }
        catch (IOException e) {
            e.printStackTrace(System.err);
        }
        
        // Désérialisation
        try(var in = Files.newInputStream(cheminBin); 
            var deserialiseur = new ObjectInputStream(in))
        {
            var animalerie2 = (Animalerie)deserialiseur.readObject();

            Arrays
                .stream(animalerie2.getAnimaux())
                .forEach(System.out::println);
        }
        catch (IOException e) {
            e.printStackTrace(System.err);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
            
        // Sérialisation XML
        try(var outXml = Files.newOutputStream(Path.of("./liste.xml"));
            var encordeur = new XMLEncoder(outXml)) 
        {
            encordeur.writeObject(animalerie);
            encordeur.flush(); 
        }
        catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
