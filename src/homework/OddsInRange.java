package homework;

import java.util.Scanner;

public class OddsInRange {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int from, to;
        from = to = 0;

        System.out.print("Enter starting number of range: ");
        from = getValidInput();
        System.out.print("Enter ending number of range: ");
        to = getValidInput();

        printOddsInRange(from, to);
    }

    private static void printOddsInRange(int from, int to) {
        if (from < to) {
            for (int i = from; i < to; ++i) {
                if (i % 2 != 0) System.out.print(i + ", ");
            }
        } else {
            for (int i = from; i > to; --i) {
                if (i % 2 != 0) System.out.print(i + ", ");
            }
        }
    }

    private static int getValidInput() {
        while (!scan.hasNextInt()) {
            System.out.print("Not valid input. Enter integer number : ");
            scan.next();
        }
        return scan.nextInt();
    }
}
