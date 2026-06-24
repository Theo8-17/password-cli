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
        StrengthChecker checkerLocal;
        try {
            if (useDocker) {
                checkerLocal = new DockerStrengthChecker();
            } else {
                checkerLocal = new LocalStrengthChecker();
            }
        } catch (Exception e) {
            checkerLocal = new LocalStrengthChecker();
        }
        this.checker = checkerLocal;
    }

    public String check(String password) {
        return checker.checkStrength(password);
    }
}