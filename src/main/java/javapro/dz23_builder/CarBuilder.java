package javapro.dz23_builder;

public class CarBuilder {
    private String brand;
    private String color;
    private int year;

    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public Car build() {
        return new Car(brand, color, year);
    }
}