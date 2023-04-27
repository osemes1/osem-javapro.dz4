package javapro.dz4;

public class Cat extends Animal{

    static int countCat = 0;
    public Cat() {
        countCat++;
    }

    private final int MAX_RUN_LENGTH = 200;

    @Override
    public void run(int length) {
        super.run(length);
        if ((length >= 0) && (length <= MAX_RUN_LENGTH)) System.out.println("run: true");
        else System.out.println("run: false");
    }

    @Override
    public void swim(int length) {
        super.swim(length);
        System.out.println("swim: false");
    }
}
