package main.java.com.securepass.cli;

import main.java.com.securepass.model.PasswordOptions;

/**
 * CommandParser est responsable de l'interprétation des arguments
 * passés en ligne de commande (CLI).
 *
 * Il transforme des options textuelles en objet PasswordOptions
 * exploitable par le générateur.
 */
public class CommandParser {

    /**
     * Analyse les arguments du terminal et construit une configuration.
     *
     * Exemple :
     * --length=12 --count=5 --symbols
     *
     * @param args arguments CLI
     * @return configuration PasswordOptions
     */
    public static PasswordOptions parse(String[] args) {

        // Valeurs par défaut (sécurité + simplicité)
        int length = 12;
        int count = 1;

        boolean upper = true;
        boolean lower = true;
        boolean digits = true;
        boolean symbols = false;

        // Lecture des arguments
        for (String arg : args) {

            if (arg.startsWith("--length=")) {
                length = Integer.parseInt(arg.split("=")[1]);
            }

            else if (arg.startsWith("--count=")) {
                count = Integer.parseInt(arg.split("=")[1]);
            }

            else if (arg.equals("--no-upper")) {
                upper = false;
            }

            else if (arg.equals("--no-lower")) {
                lower = false;
            }

            else if (arg.equals("--no-digits")) {
                digits = false;
            }

            else if (arg.equals("--symbols")) {
                symbols = true;
            }
        }

        // Construction finale de l'objet configuration
        return new PasswordOptions(length, upper, lower, digits, symbols, count);
    }
}
