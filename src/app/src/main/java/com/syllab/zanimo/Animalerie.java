package com.syllab.zanimo;

import java.io.Serializable;

public class Animalerie implements Serializable
{
    public Animalerie()                      { }
    public Animalerie(Animal[] animaux)      { setAnimaux(animaux); } 
    public Animal[] getAnimaux()             { return this.animaux; }
    public void setAnimaux(Animal[] animaux) { this.animaux = animaux; }
    
    private Animal[] animaux;
}
