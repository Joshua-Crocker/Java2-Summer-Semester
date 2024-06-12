package Java_Assignments.Java_Assignment2.Question2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// Keyword class. All keywords in the keyword file will be made into a class.
class Keyword {
    private String keyword;
    private int points;

    public Keyword(String keyword, int points) {
        this.keyword = keyword;
        this.points = points;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getPoints() {
        return points;
    }
}

public class PhishingEmailDetector {

    // Create a list of keywords
    private static final List<Keyword> keywords = new ArrayList<>();

    // HashMap / Dictionary for storing all the keywords that appear in an email.
    static HashMap<String, List<Integer>> occurrences = new HashMap<>();

    // Function to load the keywords from the keyword file, separate the word from the point value, and add it to the class
    private static void loadKeywordsFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                if (parts.length == 2) {
                    String keyword = parts[0].toLowerCase();
                    int points = Integer.parseInt(parts[1]);
                    keywords.add(new Keyword(keyword, points));
                }
            }
        }
    }

    // Function to evaluate the phishing emails. It gets each individual line and gives it to the processLine function
    private static void evaluatePhishingEmails(Path emailFilePath) throws IOException {
        if (Files.exists(emailFilePath)) {
            System.out.println("File exists");
            try (BufferedReader reader = Files.newBufferedReader(emailFilePath)) {
                String line;
                int totalPoints = 0;
                while ((line = reader.readLine()) != null) {
                    totalPoints += processLine(line.toLowerCase());
                }
                System.out.println("Total Points for this email: " + totalPoints);
            }
        } else {
            System.out.println("File does not exist");
        }
    }

    // Function to process each line, find keywords, get their values, and then send the keyword to count occurrences.
    private static int processLine(String line) {
        int linePoints = 0;
        for (Keyword keyword : keywords) {
            String matchWord = keyword.getKeyword();
            int occurrencesInLine = countOccurrences(line, matchWord);
            if (occurrencesInLine > 0) {
                int points = keyword.getPoints();
                if (occurrences.containsKey(matchWord)) {
                    List<Integer> values = occurrences.get(matchWord);
                    values.set(1, values.get(1) + occurrencesInLine);
                    linePoints += points * occurrencesInLine;
                } else {
                    List<Integer> values = new ArrayList<>();
                    values.add(points);
                    values.add(occurrencesInLine);
                    occurrences.put(matchWord, values);
                    linePoints += points * occurrencesInLine;
                }
            }
        }
        return linePoints;
    }

    // Function to count occurrences in the email.
    private static int countOccurrences(String text, String keyword) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Path emailPath = Paths.get("./Emails");
        Path emailKeyWordsPath = Paths.get("./EmailKeyWords/PhishingEmailCommonWords.txt");

        loadKeywordsFromFile(emailKeyWordsPath.toString());

        for (Keyword keyword : keywords) {
            System.out.println(keyword.getKeyword() + ": " + keyword.getPoints());
        }

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(emailPath)) {
            for (Path p : directoryStream) {
                evaluatePhishingEmails(p);
            }
        }
    }
}
