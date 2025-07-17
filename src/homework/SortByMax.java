package homework;

import java.util.Arrays;
import java.util.Random;

public class SortByMax {
    static Random rand = new Random();

    public static void main(String[] args) {
        int[] array = new int[20];
        initArray(array);

        System.out.println("Initial array: " + Arrays.toString(array));

        bubbleSort(array, findMax(array));

        System.out.println("Sorted array: " + Arrays.toString(array));

    }

    private static void initArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = rand.nextInt(100);
        }
    }

    private static int findMax(int[] array) {
        int maxIndex = 0;
        int i = 0;
        for (int elem : array) {
            if (array[maxIndex] < elem) {
                maxIndex = i;
            }
            ++i;
        }
        return maxIndex;
    }

    private static void bubbleSort(int[] array, int maxIndex) {
        //ascending from start to maxIndex
        for (int i = 0; i < maxIndex - 1; i++) {
            for (int j = 0; j < maxIndex - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        //descending from maxIndex to end
        for (int i = 0; i < array.length - maxIndex - 1; i++) {
            for (int j = maxIndex + 1; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
