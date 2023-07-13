package javapro.dz23_strategy;

public class ExampleStrategy {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        // Calculate rectangle area
        Rectangle rectangle = new Rectangle(6, 4);
        calculator.setShape(rectangle);
        double rectangleArea = calculator.calculateArea();
        System.out.println("Rectangle Area: " + rectangleArea);

        // Calculate triangle area
        Triangle triangle = new Triangle(2, 6);
        calculator.setShape(triangle);
        double triangleArea = calculator.calculateArea();
        System.out.println("Triangle Area: " + triangleArea);
    }
}