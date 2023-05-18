package javapro.dz11;

import java.util.concurrent.Semaphore;
import java.util.LinkedList;
import java.util.Queue;

public class PetrolStation {
    private double amount;
    private final Queue<Double> queue;
    private final Semaphore semaphore;

    public PetrolStation(double initialAmount) {
        this.amount = initialAmount;
        this.queue = new LinkedList<>();
        this.semaphore = new Semaphore(3);
    }

    public void doRefuel(double requestedAmount) {
        try {
            semaphore.acquire();

            synchronized (this) {
                queue.offer(requestedAmount);
                System.out.println(String.format("Car queued for refueling. Requested amount: %f",requestedAmount));

                while (queue.peek() != requestedAmount) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(String.format("Car is being refueled. Requested amount: %f",requestedAmount));

                try {
                    Thread.sleep((long) (Math.random() * 8000 + 3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                amount -= requestedAmount;
                System.out.println(String.format("Car refueling complete. Requested amount: %f, Remaining fuel amount: %f",requestedAmount,amount));
                queue.poll();
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

