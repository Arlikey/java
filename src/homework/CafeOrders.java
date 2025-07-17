package homework;

import java.util.Scanner;

public class CafeOrders {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("How many peoples in your company? (for exit enter 0): ");
            int peopleCount = getValidInput();

            if (peopleCount <= 0) {
                break;
            }

            String[] products = {
                    "Coffee", "Tea", "Orange Juice", "Cookies", "Strawberry Cake", "Candies"
            };
            float[] prices = {
                    5.99f, 3.50f, 4.99f, 6.25f, 12.89f, 0.89f
            };

            float total = 0;

            for (int i = 1; i <= peopleCount; i++) {
                System.out.println("\n~~~~~~~~~~ MENU FOR CLIENT #" + i + " ~~~~~~~~~~");
                float personalTotal = handleClientOrder(products, prices);
                System.out.println("Total price for CLIENT #" + i + " : " + personalTotal + " $");
                total += personalTotal;
            }

            System.out.println("\nTotal price for COMPANY : " + total + " $\n");
        }
    }

    private static float handleClientOrder(String[] products, float[] prices) {
        float total = 0;

        while (true) {
            printMenu(products, prices);
            System.out.println("CURRENT PRICE : " + total + " $");
            System.out.print("Choose what you prefer (to stop enter 0) : ");
            int choice = getValidInput();

            if (choice == 0) break;

            if (choice >= 1 && choice <= products.length) {
                String item = products[choice - 1];
                float price = prices[choice - 1];
                total += price;
                System.out.println("\nAdded : " + item + " (" + price + " $)\n");
            } else {
                System.out.println("Incorrect variant. Try again!");
            }
        }

        return total;
    }

    private static void printMenu(String[] products, float[] prices) {
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " - " + prices[i] + " $");
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
