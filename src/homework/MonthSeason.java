package homework;

import java.util.Scanner;

public class MonthSeason {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int userMonth = 0;

        while (true) {
            System.out.print("Enter month (1-12) (for exit enter 0): ");

            if (scan.hasNextInt()) {
                userMonth = scan.nextInt();
            } else {
                System.out.println("Enter valid month number!");
                scan.next();
                continue;
            }

            if (userMonth == 0) {
                break;
            }

            switch (userMonth) {
                case 1, 2, 12:
                    System.out.println("Winter");
                    break;
                case 3, 4, 5:
                    System.out.println("Spring");
                    break;
                case 6, 7, 8:
                    System.out.println("Summer");
                    break;
                case 9, 10, 11:
                    System.out.println("Autumn");
                    break;
                default:
                    System.out.println("Enter month from 1 to 12!");
            }
        }
    }
}
