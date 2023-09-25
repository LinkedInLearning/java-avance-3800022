package com.syllab.ventes;

import java.util.UUID;

/**
 * Représente un article avec un nom et un prix de vente.
 */
public class Article {
    @SuppressWarnings("unused")
    private final UUID uuid = UUID.randomUUID();
    private String nom;
    private double prixHt;

    /**
     * Initialise un article, défini par un nom et son prix de vente hors taxe.
     * @param nom Nom de l'article.
     * @param prixHt Prix de vente hors taxe.
     */
    public Article(String nom, double prixHt) {
        this.nom = nom;
        this.prixHt = prixHt;
    }
    /**
     * Obtient le nom de l'article
     * @return Nom de l'article
     */
    public String nom() {
        return this.nom;
    }
    /**
     * Obtient le prix de vente hors taxe de l'article.
     * @return Prix hors taxe de l'article.
     */
    public double prixHt() {
        return this.prixHt;
    }
    /**
     * Obtient le prix de vente TTC de l'article pour une TVA à 20%.
     * @deprecated Conservé pour compatibilité
     * @return Prix de vente TTC
     * @see #prixTTC(double)
     */
    @Deprecated
    public double prixTTC() {
        return prixHt()*1.2;
    }
    /**
     * Obtient le prix de vente TTC de l'article pour un taux donné.
     * @param tva Taux de tva utilisé pour le calcul. Ex: 0.2 = 20%
     * @return Prix de vente TTC
     */
    public double prixTTC(double tva) {
        return prixHt()*(1+tva);
    }
    /**
     * Substitue la conversion d'un article en chaîne de caractère 
     * en concaténant son nom et prix de vente hors taxe.
     * @return Chaîne représentant l'article
     */
    @Override
    public String toString() {
        return String.format("%s (%.2f)", nom(), prixHt());
    }
}
