package javapro.dz10;

import java.util.Arrays;

public class ValueCalculator {
    private final double[] arr;
    private final int size = 1000000;
    private final int halfSize = size / 2;

    public ValueCalculator() {
        arr = new double[size];
    }

    public void calculate() {
        long start = System.currentTimeMillis();

        Arrays.fill(arr, 1.0);

        double[] a1 = new double[halfSize];
        double[] a2 = new double[halfSize];

        System.arraycopy(arr, 0, a1, 0, halfSize);
        System.arraycopy(arr, halfSize, a2, 0, halfSize);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + (double) i / 5) * Math.cos(0.2f + (double) i / 5) * Math.cos(0.4f + (double) i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (double) (i + halfSize) / 5) * Math.cos(0.2f + (double) (i + halfSize) / 5) * Math.cos(0.4f + (double) (i + halfSize) / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, halfSize);
        System.arraycopy(a2, 0, arr, halfSize, halfSize);

        long end = System.currentTimeMillis();

        System.out.println(String.format("Execution time: %d ms",(end - start)));
    }
}
