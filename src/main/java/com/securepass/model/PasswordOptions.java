package main.java.com.securepass.model;

/**
 * PasswordOptions représente la configuration choisie par l'utilisateur
 * pour générer des mots de passe sécurisés.
 *
 * Cette classe agit comme un conteneur de paramètres (DTO simple)
 * afin de séparer la logique métier de la configuration utilisateur.
 */
public class PasswordOptions {

    // Longueur du mot de passe généré
    public int length;

    // Inclusion des types de caractères
    public boolean useUpper;
    public boolean useLower;
    public boolean useDigits;
    public boolean useSymbols;

    // Nombre de mots de passe à générer (mode rafale)
    public int count;

    /**
     * Constructeur principal permettant d'initialiser toutes les options.
     *
     * @param length taille du mot de passe
     * @param useUpper inclusion des majuscules
     * @param useLower inclusion des minuscules
     * @param useDigits inclusion des chiffres
     * @param useSymbols inclusion des symboles spéciaux
     * @param count nombre de mots de passe à générer
     */
    public PasswordOptions(int length,
                           boolean useUpper,
                           boolean useLower,
                           boolean useDigits,
                           boolean useSymbols,
                           int count) {

        this.length = length;
        this.useUpper = useUpper;
        this.useLower = useLower;
        this.useDigits = useDigits;
        this.useSymbols = useSymbols;
        this.count = count;
    }
}