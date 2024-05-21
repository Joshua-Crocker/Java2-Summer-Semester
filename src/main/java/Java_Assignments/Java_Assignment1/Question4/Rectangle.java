package Java_Assignments.Java_Assignment1.Question4;

public class Rectangle extends Shape{

    private double length;
    private double width;

    public Rectangle(double length, double width) throws InvalidShapeParameterException {
        if (length <= 0 || width <= 0) {
            throw new InvalidShapeParameterException();
        } else {
            this.length = length;
            this.width = width;
        }
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) throws InvalidShapeParameterException {
        if (length <= 0) {
            throw new InvalidShapeParameterException();
        } else {
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) throws InvalidShapeParameterException {
        if (width <= 0) {
            throw new InvalidShapeParameterException();
        } else {
            this.width = width;
        }
    }

    @Override
    public Double area() {
        return length * width;
    }

    @Override
    public String getDescription() {
        return String.format("Rectangle with a length %.1f and width %.1f has a area of %.1f", length, width, area());
    }
}
