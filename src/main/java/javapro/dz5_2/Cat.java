package javapro.dz5_2;

class Cat extends Participant {
    public Cat(String name, int maxRunDistance, int maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(String.format("%s пробіг дистанцію %d",name,distance));
        } else {
            System.out.println(String.format("%s не зміг пробігти дистанцію %d",name,distance));
            throw new RuntimeException();
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(String.format("%s перестрибнув стіну висотоюю %d",name,height));
        } else {
            System.out.println(String.format("%s не зміг перестрибнути стіну висотою %d",name,height));
            throw new RuntimeException();
        }
    }
}