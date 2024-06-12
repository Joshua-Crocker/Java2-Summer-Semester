package Java_Assignments.Java_Assignment3.Question4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RedactInfo {

    public static void RedactPersonalInfo(Path inputFile, Path outputFile) throws IOException {
        try (BufferedReader input = Files.newBufferedReader(inputFile);
            BufferedWriter output = Files.newBufferedWriter(outputFile)) {
            String line;

            while ((line = input.readLine()) != null) {
                // Replace dates
                line = line.replaceAll("\\b\\d{2}-\\d{2}-(?:\\d{2}|\\d{4})\\b", "##-##-####");

                // Replace credit card numbers
                line = line.replaceAll("\\b\\d{4}-\\d{4}-\\d{4}-\\d{4}\\b", "####-####-####-####");

                // Replace currency amounts
                line = line.replaceAll("\\$\\d+(\\.\\d{2})?", "\\$##.##");

                // Replace codes
                line = line.replaceAll("\\bCODE\\w{17}\\b", "CODE################");
                output.write(line + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Path inputFile = Paths.get("sampleInfo.txt");
        Path outputFile = Paths.get("sampleInfoRedacted.txt");

        try {
            RedactPersonalInfo(inputFile, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
