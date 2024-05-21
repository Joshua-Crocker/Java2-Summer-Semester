package Java_Assignments.Java_Assignment1.Question7;

public class ass1_ques7 {
    public static void someMethod2() throws Exception {
        throw new Exception("Exception thrown in someMethod2.");
    }

    public static void someMethod() throws  Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("Caught an exception in someMethod.");
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println("Caught the exception that was rethrown.");
            e.printStackTrace();
        }
    }
}
