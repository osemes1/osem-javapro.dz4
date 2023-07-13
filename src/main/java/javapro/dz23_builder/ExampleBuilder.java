package javapro.dz23_builder;

public class ExampleBuilder {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();

        Car car = carBuilder
                .setBrand("Skoda")
                .setColor("Black")
                .setYear(2023)
                .build();

        System.out.println("Brand: " + car.getBrand());
        System.out.println("Color: " + car.getColor());
        System.out.println("Year: " + car.getYear());
    }
}