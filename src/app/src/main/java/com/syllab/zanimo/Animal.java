package com.syllab.zanimo;

import java.util.Arrays;
import java.util.List;

public class Animal {
    private int id;
    private String nom;
    private List<String> photoUrls;
    private Statut statut;

    public Animal() {}

    public Animal(int id, String nom, Statut statut, String[] photoUrls) {
        setId(id);
        setNom(nom);
        setStatut(statut);
        setPhotoUrls(photoUrls);
    }

    public int  getId()       { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom()           { return nom; }
    public void   setNom(String nom) { this.nom = nom; }

    public Statut getStatut()              { return statut; }
    public void   setStatut(Statut statut) { this.statut = statut; }

    public Iterable<String> getPhotoUrls()                   { return photoUrls; }
    public void             setPhotoUrls(String[] photoUrls) { this.photoUrls = Arrays.asList(photoUrls); }

    @Override
    public String toString() {
        return String.format("[%d] %s (%s)", getId(), getNom(), getStatut());
    }
}
