package javapro.dz11;

public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(100.0);

        for (int i = 0; i < 5; i++) {
            double requestedAmount = Math.random() * 30 + 10;
            Thread thread = new Thread(() -> petrolStation.doRefuel(requestedAmount));
            thread.start();
        }

        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();

        threadSafeList.add(10);
        threadSafeList.add(20);
        threadSafeList.add(30);

        int element = threadSafeList.get(1);
        System.out.println("Element at index 1: " + element);

        threadSafeList.remove(20);

        for (int i = 0; i < threadSafeList.size(); i++) {
            System.out.println(String.format("Element at index %d: %d",i,threadSafeList.get(i)));
        }
    }
}

