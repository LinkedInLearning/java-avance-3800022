package com.syllab.ventes;

import java.time.Instant;
import java.util.regex.Pattern;

/**
 * Représente un article avec un nom et un prix de vente.
 */
public class Article {
    private static Pattern validref = null;
    private final String ref, nom;
    private final double prixHt;
    private Instant abandonne = Instant.MAX;

    /**
     * Initialise un article, défini par une référence, un nom et son prix de vente hors taxe.
     * @param ref Référence de l'article : 2 lettres majuscules suivies de 2 chiffres.
     * @param nom Nom de l'article.
     * @param prixHt Prix de vente hors taxe.
     * @throws NullPointerException Nom de l'article null
     * @throws IllegalArgumentException Nom ou prix non valide
     */
    public Article(String ref, String nom, double prixHt) {
        if(validref == null) {
            validref = Pattern.compile("[A-Z]{2}\\d{2}");
        }
        if(!validref.matcher(ref).matches()) {
            throw new IllegalArgumentException("La ref de l'article est constituée de 2 lettres suivies de 2 chiffres.");
        }
        if(nom == null) {
            throw new NullPointerException("Le nom de l'article doit être renseigné.");
        }
        if(nom.length()<2) {
            throw new IllegalArgumentException("Le nom de l'article doit faire au moins 2 caractères.");
        }
        if(prixHt<=0) {
            throw new IllegalArgumentException("Le prix doit être strictement positif.");
        }
        this.ref = ref;
        this.nom = nom;
        this.prixHt = prixHt;
    }
    /**
     * Obtient la référence de l'article.
     * @return Référence de l'article.
     */
    public String ref() {
        return this.ref;
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
     * Compare deux articles selon leur référence.
     * @param a Premier article à comparer.
     * @param b Second article à comparer.
     * @return <0 si la référence de a précède celle de b, 0 si les deux références sont identiques, >0 sinon.
     */
    public static int comparerRef(Article a, Article b) {
        return a.ref().compareTo(b.ref());
    }
    /**
     * Obtient le prix de vente hors taxe de l'article.
     * @return Prix hors taxe de l'article.
     * @throws IllegalStateException Article abandonné (non disponible)
     */
    public double prixHt() {
        if(estAbandonne()) {
            throw new IllegalStateException("Article abandonné, pas de prix disponible.");
        }
        return this.prixHt;
    }
    /**
     * Obtient le prix de vente TTC de l'article pour un taux donné.
     * @param tva Taux de tva utilisé pour le calcul. Ex: 0.2 = 20%
     * @return Prix de vente TTC
     * @throws IllegalArgumentException Taux de TVA négatif.
     */
    public double prixTTC(double tva) {
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
            ? String.format("[%s] %s (abandonné)", ref(), nom())
            : String.format("[%s] %s (%.2f)", ref(), nom(), this.prixHt);
    }
}
