import Java_Assignments.Java_Assignment1.Question4.Circle;
import Java_Assignments.Java_Assignment1.Question4.InvalidShapeParameterException;
import Java_Assignments.Java_Assignment1.Question4.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    public void circleTest() throws InvalidShapeParameterException {
        Circle circle = new Circle(10.0);
        Assertions.assertEquals("314.16",String.format("%.2f",circle.area()));
        Assertions.assertEquals("Circle with radius 10.0 has a area of 314.16", circle.getDescription());

        InvalidShapeParameterException thrown = Assertions.assertThrows(
                InvalidShapeParameterException.class,
                () -> new Circle(-10.0),
                "Expected to throw, but it didn't"
        );
        Assertions.assertEquals("Shape parameter is not valid!", thrown.getMessage());
    }

    @Test
    public void rectangleTest() throws InvalidShapeParameterException {
        Rectangle rectangle = new Rectangle(5,10);
        Assertions.assertEquals(50, rectangle.area(), 0.0);
        Assertions.assertEquals("Rectangle with a length 5.0 and width 10.0 has a area of 50.0", rectangle.getDescription());

        InvalidShapeParameterException thrownForLength = Assertions.assertThrows(
                InvalidShapeParameterException.class,
                () -> new Rectangle(-5, 10),
                "Expected to throw, but it didn't"
        );
        Assertions.assertEquals("Shape parameter is not valid!", thrownForLength.getMessage());

        InvalidShapeParameterException thrownForWidth = Assertions.assertThrows(
                InvalidShapeParameterException.class,
                () -> new Rectangle(5, -10),
                "Expected to throw, but it didn't"
        );
        Assertions.assertEquals("Shape parameter is not valid!", thrownForWidth.getMessage());
    }
}