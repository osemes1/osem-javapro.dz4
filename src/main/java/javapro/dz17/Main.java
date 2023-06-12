package javapro.dz17;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Перша коробка з яблуками має вагу: " + appleBox1.getWeight());
        System.out.println("Друга коробка з яблуками має вагу:  " + appleBox2.getWeight());
        System.out.println("Коробка з апельсинами має вагу: " + orangeBox.getWeight());

        System.out.println("Чи перша коробка з яблуками така ж як і друга? " + appleBox1.compare(appleBox2));
        System.out.println("Чи перша коробка з яблуками така ж як і коробка з апельсинами? " + appleBox1.compare(orangeBox));

        appleBox1.merge(appleBox2);

        System.out.println("Перша коробка з яблуками після об'єднання має вагу: " + appleBox1.getWeight());
        System.out.println("Друга коробка з яблуками після об'єднання має вагу: " + appleBox2.getWeight());
    }
}

