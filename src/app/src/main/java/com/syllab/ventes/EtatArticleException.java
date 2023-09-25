package com.syllab.ventes;

/**
 * Exception déclenchée lors d'une utilisation incohérente d'une 
 * méthode d'un article relativement à l'état de cet article.
 */
public class EtatArticleException extends Exception {
    private Article article;

    /**
     * Initialise l'exception concernant l'état d'un article.
     * @param article Article à l'origine de l'exception.
     * @param message Message décrivant le problème.
     */
    public EtatArticleException(Article article, String message) {
        super(message);
        this.article = article;
    }
    /**
     * Obtient l'article à l'origine de l'exception.
     * @return Article à l'origine de l'exception.
     */
    public Article article() {
        return this.article;
    }
}
