package main.java.com.securepass.strength;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DockerStrengthChecker implements StrengthChecker {

    @Override
    public String checkStrength(String password) {

        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "docker", "run", "--rm",
                    "zxcvbn-check",
                    password
            );

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line = reader.readLine();
            process.waitFor();

            if (line == null) return "Erreur";

            int score = Integer.parseInt(line.trim());

            return switch (score) {
                case 0 -> "Très faible";
                case 1 -> "Faible";
                case 2 -> "Moyen";
                case 3 -> "Fort";
                default -> "Très fort";
            };

        } catch (Exception e) {
            return "Erreur Docker";
        }
    }
}