package com.syllab.premiers;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveAction;

public class RecherchePremiers extends RecursiveAction {
    private final CopyOnWriteArrayList<Long> liste;
    private final long debut, fin;

    public RecherchePremiers(CopyOnWriteArrayList<Long> liste, long debut, long fin) {
        this.liste = liste;
        this.debut = debut;
        this.fin = fin;
    }
  
    private boolean estPremier(long n) {
        for(long premier : this.liste) {
            if(n<premier && n%premier == 0) {
                return false;
            }
        }
        for(long i=2; i<n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    private final static long SEUIL = 200;

    @Override
    protected void compute() {
        if(this.fin - this.debut < SEUIL) {
            var resultats = new ArrayList<Long>();
            for(long i = this.debut; i<this.fin; i++) {
                if(estPremier(i)) {
                    resultats.add(i);
                }
            }
            this.liste.addAll(resultats);
        }
        else {
            var milieu = (this.debut+this.fin)/2;
            var moitie1 = new RecherchePremiers(this.liste, this.debut, milieu);
            var moitie2 = new RecherchePremiers(this.liste, milieu, this.fin);

            invokeAll(moitie1, moitie2);
        }
    }
}
