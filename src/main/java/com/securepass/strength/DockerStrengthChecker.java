package main.java.com.securepass.strength;

/**
 * Implémentation future utilisant un conteneur Docker
 * pour analyser la robustesse des mots de passe.
 *
 * Cette classe remplacera progressivement LocalStrengthChecker
 * dans une approche DevOps.
 */
public class DockerStrengthChecker implements StrengthChecker {

    @Override
    public String checkStrength(String password) {

        // POUR L’INSTANT : simulation (placeholder DevOps)

        // Plus tard :
        // - appel Docker via ProcessBuilder
        // - envoi du password
        // - récupération du score

        if (password.length() < 8) return "Très faible";
        if (password.length() < 12) return "Faible";

        return "Fort (Docker simulé)";
    }
}