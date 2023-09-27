package com.syllab.premiers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecherchePremiers extends RecursiveTask<List<Long>> {
    private final long debut, fin;

    public RecherchePremiers(long debut, long fin) {
        this.debut = debut;
        this.fin = fin;
    }
  
    private boolean estPremier(long n) {
        for(long i=2; i<n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    private final static long SEUIL = 200;

    @Override
    protected List<Long> compute() {
        List<Long> resultats;

        if(this.fin - this.debut < SEUIL) {
            resultats = new ArrayList<Long>();
            for(long i = this.debut; i<this.fin; i++) {
                if(estPremier(i)) {
                    resultats.add(i);
                }
            }
        }
        else {
            var milieu = (this.debut+this.fin)/2;
            var moitie1 = new RecherchePremiers(this.debut, milieu);
            var moitie2 = new RecherchePremiers(milieu, this.fin);

            moitie2.fork();
            resultats = moitie1.compute();
            resultats.addAll(moitie2.join());
        }
        return resultats;
    }
}
