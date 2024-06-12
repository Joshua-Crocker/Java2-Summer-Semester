package Java_Assignments.Java_Assignment2.Question1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class PhoneNumberWordGenerator {

    // Mapping of digits to corresponding letters
    private static final String[] KEYPAD_MAPPING = {
            "",     // 0
            "",     // 1
            "ABC",  // 2
            "DEF",  // 3
            "GHI",  // 4
            "JKL",  // 5
            "MNO",  // 6
            "PRS",  // 7
            "TUV",  // 8
            "WXY"   // 9
    };

    // Function to generate the proper combinations. This function is recursive.
    private static void generateCombinations(String phoneNumber, String currentWord, int index, List<String> results) {
        if (index == phoneNumber.length()) {
            results.add(currentWord);
            return;
        }

        int digit = phoneNumber.charAt(index) - '0';
        String letters = KEYPAD_MAPPING[digit];
        for (int i = 0; i < letters.length(); i++) {
            generateCombinations(phoneNumber, currentWord + letters.charAt(i), index + 1, results);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a phone number. Do not use a 1 or 0.");

        // Uncleansed phone number, if someone enters a "-" character without cleansing the phone number then the program will crash
        String uncleanesedPhoneNumber = input.nextLine();

        // Cleansed phone number
        String phoneNumber = "";

        // Cleanse the phone number
        if (uncleanesedPhoneNumber.contains("-")) {
            phoneNumber = uncleanesedPhoneNumber.replace("-", "");
        }

        // Check the phone number for a 0 or 1. If it exists stop the program.
        if (phoneNumber.contains("0") || phoneNumber.contains("1")) {
            System.out.println("Phone number cannot contain 0 or 1.");
            return;
        }

        List<String> results = new ArrayList<>();
        generateCombinations(phoneNumber, "", 0, results);

        try (Formatter output = new Formatter("./combinationsOfPhoneNumber" + phoneNumber + ".txt")) {
            for (String word : results) {
                output.format("%s%n", word);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
