package main.java.com.securepass.util;

import java.security.SecureRandom;

/**
 * Classe utilitaire pour les opérations liées au hasard.
 *
 * On utilise SecureRandom pour garantir une génération sécurisée
 * adaptée aux mots de passe.
 */
public class RandomUtils {

    private static final SecureRandom random = new SecureRandom();

    /**
     * Retourne un index aléatoire dans une plage donnée.
     *
     * @param bound limite supérieure
     * @return index aléatoire
     */
    public static int randomIndex(int bound) {
        return random.nextInt(bound);
    }
}