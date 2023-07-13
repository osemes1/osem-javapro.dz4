package javapro.dz23_strategy;

public class AreaCalculator {
    private Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double calculateArea() {
        if (shape != null) {
            return shape.calculateArea();
        } else {
            throw new IllegalStateException("Shape is not set");
        }
    }
}