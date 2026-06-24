package main.java.com.securepass.strength;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DockerStrengthChecker implements StrengthChecker {

    @Override
    public String checkStrength(String password) {

        try {

            ProcessBuilder pb = new ProcessBuilder("docker", "run", "zxcvbn-check", password);
            pb.redirectErrorStream(true);

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
            );

            String output = reader.readLine();
            process.waitFor();

            if (output == null) {
                return "Erreur";
            }

            output = output.trim(); // IMPORTANT 🔥

            int score;

            try {
                score = Integer.parseInt(output);
            } catch (Exception e) {
                return "Erreur";
            }

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