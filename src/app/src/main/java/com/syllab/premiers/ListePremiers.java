package com.syllab.premiers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListePremiers {
    private List<Long> premiers = new ArrayList<>();
    private boolean ecriture = false;
    private Long[] copie = new Long[0];

    public synchronized void enregistrer(List<Long> premiers) throws InterruptedException {
        if(this.ecriture) {
            this.wait();
        }
        this.ecriture = true;
        this.premiers.addAll(premiers);
        this.copie = this.premiers.toArray(new Long[0]);
        this.ecriture = false;
        this.notify();
    } 
    public Long [] premiers() {
        return this.copie;
    }
    public Stream<Long> stream() {
        return this.premiers.stream();
    }
    public long size() {
        return this.premiers.size();
    }
}
