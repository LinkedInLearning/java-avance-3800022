package com.syllab.zanimo;

public class Animalerie
{
    public Animalerie()                      { }
    public Animalerie(Animal[] animaux)      { setAnimaux(animaux); } 
    public Animal[] getAnimaux()             { return this.animaux; }
    public void setAnimaux(Animal[] animaux) { this.animaux = animaux; }
    
    private Animal[] animaux;
}
