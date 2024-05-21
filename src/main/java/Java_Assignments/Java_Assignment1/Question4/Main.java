package Java_Assignments.Java_Assignment1.Question4;

public class Main {
    public static void main(String[] args) throws InvalidShapeParameterException {
        Shape[] shapes = new Shape[5];

        int num = 0;
        for (Shape shape : shapes) {
            shape = ShapeGenerator.generateShape();
            shapes[num] = shape;
            num++;
            System.out.println(shape.getDescription());
        }
    }
}