package main.java.com.securepass;
import main.java.com.securepass.cli.CommandParser;
import main.java.com.securepass.generator.PasswordGenerator;
import main.java.com.securepass.model.PasswordOptions;
import main.java.com.securepass.strength.LocalStrengthChecker;
import main.java.com.securepass.strength.StrengthChecker;
import main.java.com.securepass.strength.StrengthService;

import java.util.List;

/**
 * Point d'entrée de l'application CLI Password Generator.
 *
 * Responsabilités :
 * - Lire les arguments utilisateur
 * - Générer des mots de passe
 * - Évaluer leur robustesse (version locale)
 * - Afficher un résultat propre en terminal
 *
 * Cette classe sera plus tard enrichie avec une analyse Docker externe.
 */
public class Main {

    public static void main(String[] args) {

       try {
            PasswordOptions options = CommandParser.parse(args);

            PasswordGenerator generator = new PasswordGenerator();
            List<String> passwords = generator.generate(options);

            StrengthService checker = new StrengthService(true);

            System.out.println("\n🔐 PASSWORD GENERATOR\n");

            for (String pwd : passwords) {
                System.out.println("→ " + pwd + " [" + checker.check(pwd) + "]");
            }

        } catch (Exception e) {
            System.out.println("❌ Erreur: " + e.getMessage());
            System.out.println("Usage: --length=16 --count=5 --symbols");
        }
    }
}