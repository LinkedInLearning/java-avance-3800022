package com.syllab.premiers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListePremiers {
    private List<Long> premiers = new ArrayList<>();
    
    public void enregistrer(List<Long> premiers) {
        this.premiers.addAll(premiers);
    } 
    public Long [] premiers() {
        return this.premiers.toArray(new Long[0]);
    }
    public Stream<Long> stream() {
        return this.premiers.stream();
    }
    public long size() {
        return this.premiers.size();
    }
}
