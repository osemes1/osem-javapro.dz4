package javapro.dz15;

public class ShakerSort {
    public static void main(String[] args) {
        int[] arr = {90, 33, 6, 0, 7, 36, 18, 13, 44};

        shakerSort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void shakerSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        boolean swapped;

        do {
            swapped = false;

            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            right--;

            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }

            left++;
        } while (swapped);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

