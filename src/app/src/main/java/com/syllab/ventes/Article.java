package com.syllab.ventes;

import java.time.Instant;

/**
 * Représente un article avec un nom et un prix de vente.
 */
public class Article {
    private final String nom;
    private final double prixHt;
    private Instant abandonne = Instant.MAX;

    /**
     * Initialise un article, défini par un nom et son prix de vente hors taxe.
     * @param nom Nom de l'article.
     * @param prixHt Prix de vente hors taxe.
     * @throws NullPointerException Nom de l'article null
     * @throws IllegalArgumentException Nom ou prix non valide
     */
    public Article(String nom, double prixHt) {
        if(nom == null) {
            throw new NullPointerException("Le nom de l'article doit être renseigné.");
        }
        if(nom.length()<2) {
            throw new IllegalArgumentException("Le nom de l'article doit faire au moins 2 caractères.");
        }
        if(prixHt<=0) {
            throw new IllegalArgumentException("Le prix doit être strictement positif.");
        }
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
     * Vérifie si un article est abandonné (plus disponible).
     * @return Vrai si le article est abandonné, faux sinon.
     */
    public boolean estAbandonne() {
        return this.abandonne != Instant.MAX;
    }
    /**
     * Obtient le moment à partir duquel un article n'a plus été disponible.
     * @return Moment à partir duquel l'article n'a plus été disponible.
     */
    public Instant abandonne() {
        return this.abandonne;
    }
    /**
     * Spécifie le moment à partir duquel l'article n'est ou ne sera plus disponible.
     * @param moment Moment à partir duquel l'article n'est ou ne sera plus disponible.
     */
    public void abandonner(Instant moment) {
        this.abandonne = moment;
    }
    /**
     * Obtient le prix de vente hors taxe de l'article.
     * @return Prix hors taxe de l'article.
     * @throws EtatArticleException Article abandonné (non disponible)
     */
    public double prixHt() throws EtatArticleException {
        if(estAbandonne()) {
            throw new EtatArticleException(this, "Article abandonné, pas de prix disponible.");
        }
        return this.prixHt;
    }
    /**
     * Obtient le prix de vente TTC de l'article pour un taux donné.
     * @param tva Taux de tva utilisé pour le calcul. Ex: 0.2 = 20%
     * @return Prix de vente TTC
     * @throws IllegalArgumentException Taux de TVA négatif.
     * @throws EtatArticleException Article abandonné (non disponible)
     */
    public double prixTTC(double tva) throws EtatArticleException {
        if(tva <= 0.0) {
            throw new IllegalArgumentException("Le taux de tva doit être strictement positif.");
        }
        return prixHt()*(1+tva);
    }
    /**
     * Substitue la conversion d'un article en chaîne de caractère 
     * en concaténant son nom et prix de vente hors taxe.
     * @return Chaîne représentant l'article
     */
    @Override
    public String toString() {
        return estAbandonne() 
            ? String.format("%s (abandonné)", nom())
            : String.format("%s (%.2f)", nom(), this.prixHt);
    }
}
