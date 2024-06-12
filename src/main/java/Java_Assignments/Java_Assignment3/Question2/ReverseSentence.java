package Java_Assignments.Java_Assignment3.Question2;

import java.util.Scanner;

public class ReverseSentence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a line of text: ");
        String inputLine = scanner.nextLine();

        String[] tokens = inputLine.split(" ");

        System.out.println("Printing the line in reverse order: ");
        for (int i = tokens.length - 1; i >= 0; i--) {
            System.out.print(tokens[i] + " ");
        }
    }
}
