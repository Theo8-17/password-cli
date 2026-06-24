package main.java.com.securepass;
import main.java.com.securepass.cli.CommandParser;
import main.java.com.securepass.generator.PasswordGenerator;
import main.java.com.securepass.model.PasswordOptions;
import main.java.com.securepass.strength.LocalStrengthChecker;
import main.java.com.securepass.strength.StrengthChecker;

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

        // Lecture des options CLI
        PasswordOptions options = CommandParser.parse(args);

        // Génération des mots de passe
        PasswordGenerator generator = new PasswordGenerator();
        List<String> passwords = generator.generate(options);

        // Analyse locale de la force (fallback avant Docker)
        StrengthChecker checker = new LocalStrengthChecker();

        // Header propre CLI
        System.out.println("\n===================================");
        System.out.println("   🔐 PASSWORD GENERATOR TOOL");
        System.out.println("===================================\n");

        System.out.println("📌 Paramètres :");
        System.out.println("- Longueur : " + options.length);
        System.out.println("- Majuscules : " + options.useUpper);
        System.out.println("- Minuscules : " + options.useLower);
        System.out.println("- Chiffres : " + options.useDigits);
        System.out.println("- Symboles : " + options.useSymbols);
        System.out.println("- Nombre : " + options.count);

        System.out.println("\n🔐 Résultats :\n");

        // Affichage des mots de passe + score
        for (String pwd : passwords) {
            String strength = checker.checkStrength(pwd);
            System.out.println("→ " + pwd + "  [" + strength + "]");
        }

        System.out.println("\n===================================\n");
    }
}