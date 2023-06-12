package javapro.dz17;

import java.util.ArrayList;
import java.util.List;

class Fruit {
    private double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

class Apple extends Fruit {
    public Apple() {
        super(100);
    }
}

class Orange extends Fruit {
    public Orange() {
        super(150);
    }
}

class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(getWeight() - otherBox.getWeight()) < 0.0011;
    }

    public void merge(Box<T> otherBox) {
        if (this == otherBox) {
            return;
        }
        fruits.addAll(otherBox.fruits);
        otherBox.fruits.clear();
    }
}
