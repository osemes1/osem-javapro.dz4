package javapro.dz23_factory;

public class FurnitureFactory {
    public Furniture createFurniture(String type) {
        if (type.equalsIgnoreCase("table")) {
            return new Table();
        } else if (type.equalsIgnoreCase("chair")) {
            return new Chair();
        } else if (type.equalsIgnoreCase("bed")) {
            return new Bed();
        }

        throw new IllegalArgumentException("Invalid furniture type: " + type);
    }
}
