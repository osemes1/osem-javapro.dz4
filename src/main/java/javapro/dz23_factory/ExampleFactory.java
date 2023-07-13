package javapro.dz23_factory;

public class ExampleFactory {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new FurnitureFactory();

        Furniture table = furnitureFactory.createFurniture("table");
        table.assemble();

        Furniture chair = furnitureFactory.createFurniture("chair");
        chair.assemble();

        Furniture bed = furnitureFactory.createFurniture("bed");
        bed.assemble();
    }
}