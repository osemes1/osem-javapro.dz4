package javapro.dz5_2;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human("Human 1", 100, 2),
                new Cat("Cat 1", 50, 3),
                new Robot("Robot 1", 150, 1)
        };

        Obstacle[] obstacles = {
                new Treadmill(50), new Wall(1),
                new Treadmill(100), new Wall(2),
                new Treadmill(150), new Wall(3)
        };

        for (Participant p : participants) {
            boolean isOut = false;
            System.out.println(String.format("Учасник %s готується до проходження перешкод",p.name));

            for (Obstacle o : obstacles) {
                System.out.println(String.format("Учасник %s підходить до перешкоди",p.name));

                if (!o.overcome(p)) {
                    System.out.println(String.format("Учасник %s не зміг пройти перешкоду і вилітає з гри",p.name));
                    isOut = true;
                    break;
                }
            }

            if (!isOut) {
                System.out.println(String.format("Учасник %s успішно пройшов всі перешкоди і фінішував",p.name));
            }
        }
    }
}
