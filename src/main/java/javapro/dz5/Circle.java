package javapro.dz5;

public class Circle extends Figure {
    private static final String NAME = "кола";

    private double circleRadius;

    public Circle(double circleRadius) {
        this.circleRadius = circleRadius;
    }

    @Override
    public double getArea(){
        double area = Math.PI * circleRadius * circleRadius;
        return area;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public double getCircleRadius() {
        return circleRadius;
    }

    public void setRadius(double circleRadius) {
        this.circleRadius = circleRadius;
    }
}
