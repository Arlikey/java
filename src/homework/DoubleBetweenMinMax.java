package homework;

import java.util.Arrays;
import java.util.Random;

public class DoubleBetweenMinMax {
    static Random rand = new Random();

    public static void main(String[] args) {
        int[] array = new int[20];
        initArray(array);

        System.out.println("Initial array: " + Arrays.toString(array));

        int[] boundariesIndices = findMinMaxIndices(array);
        doubleElements(array, boundariesIndices);

        System.out.println("Doubled array: " + Arrays.toString(array));

    }

    private static void initArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = rand.nextInt(100);
        }
    }

    private static int[] findMinMaxIndices(int[] array) {
        int minIndex = 0;
        int maxIndex = 0;

        int i = 0;
        for (int elem : array) {
            if (array[minIndex] > elem) {
                minIndex = i;
            }
            if (array[maxIndex] < elem) {
                maxIndex = i;
            }
            ++i;
        }

        return new int[]{minIndex, maxIndex};
    }

    private static void doubleElements(int[] array, int[] boundariesIndices) {
        int from, to;

        if (boundariesIndices[0] < boundariesIndices[1]) {
            from = boundariesIndices[0];
            to = boundariesIndices[1];
        }
        else {
            from = boundariesIndices[1];
            to = boundariesIndices[0];
        }

        // from + 1 to exclude starting element from doubling
        for (int i = from + 1; i < to; i++) {
            array[i] *= 2;
        }
    }
}
