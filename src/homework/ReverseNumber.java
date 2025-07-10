package homework;

import java.util.Scanner;

public class ReverseNumber {
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        int userNumber = 0;
        String stringUserNumber = "";

        do {
            System.out.print("Enter six-digit number (for exit enter 0): ");
            if (scan.hasNextInt()) {
                userNumber = scan.nextInt();
                if (userNumber == 0) {
                    break;
                }
                stringUserNumber = Integer.toString(userNumber);
                if (stringUserNumber.length() != 6) {
                    System.out.println("Your number isn't six digit! Try again.");
                    continue;
                }
            } else {
                System.out.println("Enter valid integer six-digit number! Try again.");
                scan.next();
                continue;
            }

            System.out.println("Reversed number: " + reverse(stringUserNumber));
        } while (true);
    }

    private static int reverse(String userNumber) {
        char[] array = userNumber.toCharArray();

        // in condition -1 to disregard the 2 middle elements
        for (int i = 0, j = array.length - 1; i < (array.length / 2) - 1; ++i, --j) {
            char buffer = array[i];
            array[i] = array[j];
            array[j] = buffer;
        }

        return Integer.parseInt(new String(array));
    }
}

