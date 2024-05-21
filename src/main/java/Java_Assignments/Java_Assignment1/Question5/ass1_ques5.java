package Java_Assignments.Java_Assignment1.Question5;

public class ass1_ques5 {
    static class ExceptionA extends Exception {

        public ExceptionA(String message) {
            super(message);
        }
    }

    static class ExceptionB extends ExceptionA {

        public ExceptionB(String message) {
            super(message);
        }
    }

    static class ExceptionC extends ExceptionB {

        public ExceptionC(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            throw new ass1_ques5.ExceptionB("ExceptionB is raised");
        } catch (ass1_ques5.ExceptionA e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        try {
            throw new ass1_ques5.ExceptionC("ExceptionC is raised");
        } catch (ass1_ques5.ExceptionA e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}