package com.syllab.premiers;

import java.util.ArrayList;
import java.util.List;

public class RecherchePremiers {
    private final long debut, fin;

    public RecherchePremiers(long debut, long fin) {
        this.debut = debut;
        this.fin = fin;
    }
    
    protected List<Long> trouver() {
        List<Long> resultats;

        resultats = new ArrayList<Long>();
        for(long i = this.debut; i<this.fin; i++) {
            if(estPremier(i)) {
                resultats.add(i);
            }
        }
        return resultats;
    }

    private boolean estPremier(long n) {
        for(long i=2; i<n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
