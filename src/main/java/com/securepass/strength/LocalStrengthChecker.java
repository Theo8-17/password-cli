package main.java.com.securepass.strength;

/**
 * Implémentation locale simple de l'analyse de robustesse.
 *
 * Cette version est utilisée comme fallback
 * avant intégration Docker.
 */
public class LocalStrengthChecker implements StrengthChecker {

    @Override
    public String checkStrength(String password) {

        int score = 0;

        // Longueur (facteur principal)
        if (password.length() >= 12) score += 2;
        else if (password.length() >= 8) score += 1;

        // Diversité des caractères
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()_+\\-].*")) score++;

        return switch (score) {
            case 0, 1 -> "Très faible";
            case 2 -> "Faible";
            case 3 -> "Moyen";
            case 4 -> "Fort";
            default -> "Très fort";
        };
    }
}