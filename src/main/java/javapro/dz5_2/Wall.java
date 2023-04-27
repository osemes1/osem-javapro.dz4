package javapro.dz5_2;

class Wall extends Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    boolean overcome(Participant p) {
        System.out.println(String.format("Учасник %s починає стрибок на висоту %d",p.name,height));
        try {
            p.jump(height);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
