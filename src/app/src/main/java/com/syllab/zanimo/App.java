package com.syllab.zanimo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) {
        var rex = new Animal(1, "Rex", Statut.EN_ATTENTE, new String[]{ "https://pixabay.com/photos/cocker-spaniel-dog-pet-puppy-3981587/", "https://pixabay.com/photos/dogs-cocker-spaniel-spaniel-dog-4716741/" });
        
        System.out.println(rex.toJson());

        try {
            var base = new URI("https://petstore.swagger.io");

            // POST /v2/pet
            var requete = HttpRequest.newBuilder(base.resolve("/v2/pet"))
                .headers("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(rex.toJson()))
                .build();
            var client = HttpClient.newHttpClient();
            var reponse = client.send(requete, BodyHandlers.ofString());

            System.out.printf("%d : %s\n", reponse.statusCode(), reponse.body());

            System.out.println();

            // GET /v2/pet/findByStatus
            reponse = client.send(
                HttpRequest
                    .newBuilder(base.resolve("/v2/pet/findByStatus?status=pending"))
                    .GET()
                    .build(), 
                BodyHandlers.ofString()
            );

            System.out.printf("%d : %s", reponse.statusCode(), reponse.body());
        }
        catch(IOException e) {
            e.printStackTrace(System.err);
        }
        catch(InterruptedException e) {
            e.printStackTrace(System.err);
        }
        catch(URISyntaxException e) {
            e.printStackTrace(System.err);
        }
    }
}
