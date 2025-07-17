package homework;

import java.util.Arrays;
import java.util.Random;

public class TwoDimensionalArray {
    static Random rand = new Random();

    public static void main(String[] args) {
        int[] array = new int[20];
        initArray(array);

        System.out.println("Initial array: " + Arrays.toString(array));

        int[][] twoDimensionArray = {
                getArrayOfEvens(array),
                getArrayOfOdds(array),
                getArrayOfNegatives(array),
                getArrayOfPositives(array)
        };

        for (int[] elem : twoDimensionArray) {
            System.out.println(Arrays.toString(elem));
        }
    }

    private static void initArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = rand.nextInt(-100, 100);
        }
    }

    private static int[] getArrayOfEvens(int[] array) {
        int size = 0;
        for (int elem : array) {
            if (elem % 2 == 0) ++size;
        }

        int[] arrayOfEvens = new int[size];

        for (int i = 0, j = 0; i < array.length; ++i) {
            if (array[i] % 2 == 0) {
                arrayOfEvens[j++] = array[i];
            }
        }

        return arrayOfEvens;
    }

    private static int[] getArrayOfOdds(int[] array) {
        int size = 0;
        for (int elem : array) {
            if (elem % 2 != 0) ++size;
        }

        int[] arrayOfOdds = new int[size];

        for (int i = 0, j = 0; i < array.length; ++i) {
            if (array[i] % 2 != 0) {
                arrayOfOdds[j++] = array[i];
            }
        }

        return arrayOfOdds;
    }

    private static int[] getArrayOfPositives(int[] array) {
        int size = 0;
        for (int elem : array) {
            if (elem > 0) ++size;
        }

        int[] arrayOfPositives = new int[size];

        for (int i = 0, j = 0; i < array.length; ++i) {
            if (array[i] > 0) {
                arrayOfPositives[j++] = array[i];
            }
        }

        return arrayOfPositives;
    }

    private static int[] getArrayOfNegatives(int[] array) {
        int size = 0;
        for (int elem : array) {
            if (elem < 0) ++size;
        }

        int[] arrayOfNegatives = new int[size];

        for (int i = 0, j = 0; i < array.length; ++i) {
            if (array[i] < 0) {
                arrayOfNegatives[j++] = array[i];
            }
        }

        return arrayOfNegatives;
    }
}
