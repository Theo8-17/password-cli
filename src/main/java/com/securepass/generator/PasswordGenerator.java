package main.java.com.securepass.generator;

import main.java.com.securepass.model.PasswordOptions;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * PasswordGenerator est responsable de la création de mots de passe sécurisés.
 *
 * Il construit dynamiquement un ensemble de caractères autorisés
 * selon les options utilisateur, puis génère des chaînes aléatoires
 * à l'aide de SecureRandom.
 *
 * Cette classe est indépendante pour faciliter les tests et évolutions
 * (ex: remplacement par un générateur plus avancé ou externe via Docker).
 */
public class PasswordGenerator {

    // Générateur sécurisé pour éviter les prédictions
    private final SecureRandom random = new SecureRandom();

    // Jeux de caractères disponibles
    private final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private final String DIGITS = "0123456789";
    private final String SYMBOLS = "!@#$%^&*()-_=+<>?";

    /**
     * Génère une liste de mots de passe selon les options fournies.
     *
     * @param options configuration utilisateur
     * @return liste de mots de passe générés
     */
    public List<String> generate(PasswordOptions options) {

        // Construction dynamique du charset selon les choix utilisateur
        StringBuilder charset = new StringBuilder();

        if (options.useUpper) charset.append(UPPER);
        if (options.useLower) charset.append(LOWER);
        if (options.useDigits) charset.append(DIGITS);
        if (options.useSymbols) charset.append(SYMBOLS);

        // Sécurité : éviter charset vide
        if (charset.isEmpty()) {
            throw new IllegalArgumentException(
                "Aucun type de caractère sélectionné pour la génération"
            );
        }

        List<String> passwords = new ArrayList<>();

        // Mode rafale : génération de plusieurs mots de passe
        for (int i = 0; i < options.count; i++) {
            passwords.add(generateOne(options.length, charset.toString()));
        }

        return passwords;
    }

    /**
     * Génère un mot de passe unique.
     *
     * @param length longueur du mot de passe
     * @param charset ensemble de caractères autorisés
     * @return mot de passe généré
     */
    private String generateOne(int length, String charset) {

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charset.length());
            password.append(charset.charAt(index));
        }

        return password.toString();
    }
}