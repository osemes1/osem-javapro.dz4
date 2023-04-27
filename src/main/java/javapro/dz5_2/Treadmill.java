package javapro.dz5_2;

class Treadmill extends Obstacle {
    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant p) {
        System.out.println(String.format("Учасник %s починає біг на довжину %d",p.name,length));
        try {
            p.run(length);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}


