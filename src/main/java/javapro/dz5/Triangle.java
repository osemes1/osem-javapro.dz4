package javapro.dz5;

public class Triangle extends Figure {
    private static final String NAME = "трикутника";

    private double triangleSideA;
    private double triangleSideB;
    private double triangleSideC;

    public Triangle(double triangleSideA, double triangleSideB, double triangleSideC) {
        this.triangleSideA = triangleSideA;
        this.triangleSideB = triangleSideB;
        this.triangleSideC = triangleSideC;
    }

    @Override
    public double getArea() {

        //вираховуємо напівперіметр трикутника
        double p = (triangleSideA + triangleSideB + triangleSideC) / 2;

        //вираховуємо площу трикутника
        double area = Math.sqrt(p * (p - triangleSideA) * (p - triangleSideB) * (p - triangleSideC));
        return area;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public double getTriangleSideA() {
        return triangleSideA;
    }

    public void setTriangleSideA(double triangleSideA) {
        this.triangleSideA = triangleSideA;
    }

    public double getTriangleSideB() {
        return triangleSideB;
    }

    public void setTriangleSideB(double triangleSideB) {
        this.triangleSideB = triangleSideB;
    }

    public double getTriangleSideC() {
        return triangleSideC;
    }

    public void setTriangleSideC(double triangleSideC) {
        this.triangleSideC = triangleSideC;
    }
}
