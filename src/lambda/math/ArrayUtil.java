package lambda.math;

import java.util.Random;

public class ArrayUtil {
    static Random rnd = new Random();

    public static void fillArray(Integer[] array, int from, int to){
        for (int i = 0; i < array.length; ++i) {
            array[i] = rnd.nextInt(from, to);
        }
    }
}
