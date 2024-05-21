package Java_Assignments.Java_Assignment1.Question6;

public class ass1_ques6 {
    static class SomeClass {
        public SomeClass() throws Exception {
            throw new Exception("Constructor Failed to construct");
        }
    }

    public static void main(String[] args) {
        try {
            ass1_ques6.SomeClass obj = new ass1_ques6.SomeClass();
        } catch (Exception e) {
            System.out.println("Caught an exception during object creation: " + e.getMessage());
        }
    }
}
