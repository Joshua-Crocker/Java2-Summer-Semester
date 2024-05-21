package Java_Assignments.Java_Assignment1.Question4;

import java.util.Random;

public class ShapeGenerator {
    public ShapeGenerator(){
    }

    public static Shape generateShape() throws InvalidShapeParameterException {
        int coinTossResult = new Random().nextInt(2);
        double radius = new Random().nextInt(200) - 100;
        double length = new Random().nextInt(200) - 100;
        double width = new Random().nextInt(200) - 100;

        try {
            if (coinTossResult == 0) {
                return new Circle(radius);
            } else {
                return new Rectangle(length, width);
            }
        } catch (InvalidShapeParameterException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return generateShape();
        }
    }
}
