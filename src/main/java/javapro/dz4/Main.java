package javapro.dz4;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i <5 ; i++) {
            new Cat();
        }

        for (int i = 0; i <3 ; i++) {
            new Dog();
        }

        System.out.println("Count cat: "+Cat.countCat);
        System.out.println("Count dog: "+Dog.countDog);

        Dog dogBobik = new Dog();
        dogBobik.run(150);

    }
}
