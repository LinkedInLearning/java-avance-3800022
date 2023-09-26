package com.syllab.zanimo;

import java.net.URI;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) {
        var rex = new Animal(1, "Rex", Statut.EN_ATTENTE, new String[]{ "https://pixabay.com/photos/cocker-spaniel-dog-pet-puppy-3981587/", "https://pixabay.com/photos/dogs-cocker-spaniel-spaniel-dog-4716741/" });
        
        System.out.println(rex.toJson());

        try {
            var base = new URI("https://petstore.swagger.io");

            // POST /v2/pet

            // GET /v2/pet/findByStatus
        }
        catch(URISyntaxException e) {
            e.printStackTrace(System.err);
        }
    }
}
