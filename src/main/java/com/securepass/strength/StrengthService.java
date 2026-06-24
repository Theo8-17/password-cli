package main.java.com.securepass.strength;

/**
 * Service qui choisit dynamiquement la stratégie d'analyse.
 *
 * Permet de switcher entre :
 * - LocalStrengthChecker
 * - DockerStrengthChecker
 */
public class StrengthService {

    private final StrengthChecker checker;

    public StrengthService(boolean useDocker) {

        if (useDocker) {
            this.checker = new DockerStrengthChecker();
        } else {
            this.checker = new LocalStrengthChecker();
        }
    }

    public String check(String password) {
        return checker.checkStrength(password);
    }
}