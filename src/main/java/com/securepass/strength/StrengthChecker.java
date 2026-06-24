package main.java.com.securepass.strength;

/**
 * Interface de stratégie pour l'évaluation de la robustesse d'un mot de passe.
 *
 * Permet de remplacer facilement l'implémentation :
 * - locale (règles simples)
 * - Docker (outil externe type zxcvbn)
 * - IA (option future)
 */
public interface StrengthChecker {

    /**
     * Analyse la force d'un mot de passe.
     *
     * @param password mot de passe à analyser
     * @return niveau de sécurité sous forme texte
     */
    String checkStrength(String password);
}