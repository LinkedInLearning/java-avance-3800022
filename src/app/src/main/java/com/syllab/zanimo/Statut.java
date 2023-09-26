package com.syllab.zanimo;

public enum Statut {
    DISPONIBLE("available"),
    EN_ATTENTE("pending"),
    VENDU("sold");

    private final String json;

    private Statut(String json) {
        this.json = json;
    }

    public String toJson() {
        return json;
    }
}
