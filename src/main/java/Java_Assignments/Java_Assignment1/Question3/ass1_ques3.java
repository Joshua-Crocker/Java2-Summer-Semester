package Java_Assignments.Java_Assignment1.Question3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ass1_ques3 {
    public static void cat(File file) throws IOException {
        RandomAccessFile input = null;
        String line = null;
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}