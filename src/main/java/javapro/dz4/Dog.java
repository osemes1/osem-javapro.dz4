package javapro.dz4;

public class Dog extends Animal {

    static int countDog = 0;

    public Dog() {
        countDog++;
    }

    private final int MAX_RUN_LENGTH = 500;
    private final int MAX_SWIM_LENGTH = 10;

    /*
    @Override
    public void run(int length) {
        super.run(length);
        if ((length >= 0) && (length <= MAX_RUN_LENGTH)) System.out.println("run: true");
    }

    @Override
    public void swim(int length) {
        super.swim(length);
        if ((length >= 0) && (length <= MAX_SWIM_LENGTH)) System.out.println("swim: true");
        else System.out.println("swim: false");
    }
*/

    @Override
    public void run(int length) {
        super.run(length);
        if ((length >= 0) && (length <= MAX_RUN_LENGTH)) System.out.println(String.format("Бобік пробіг %s м",length));
    }

    @Override
    public void swim(int length) {
        super.swim(length);
        if ((length >= 0) && (length <= MAX_SWIM_LENGTH)) System.out.println(String.format("Бобік проплив %s м",length));
        else System.out.println("swim: false");
    }

}
