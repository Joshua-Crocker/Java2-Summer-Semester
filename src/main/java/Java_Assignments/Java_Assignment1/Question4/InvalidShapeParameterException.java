package Java_Assignments.Java_Assignment1.Question4;

public class InvalidShapeParameterException extends Exception {
    private static final String MSG = "Shape parameter is not valid!";

    public InvalidShapeParameterException() {
        super(MSG);
    }
}
