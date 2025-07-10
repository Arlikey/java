package homework;

import java.util.Random;
import java.util.Scanner;

public class FuelCalculator {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        int cargoWeight = rand.nextInt(2500);
        int tankCapacity = rand.nextInt(5000);
        int distanceAtoB = rand.nextInt(400);
        int distanceBtoC = rand.nextInt(400);

        try {
            int fuelConsumption = getFuelConsumption(cargoWeight);
            printAirplaneInfo(cargoWeight, tankCapacity, distanceAtoB, distanceBtoC, fuelConsumption);
            int refuelAmount = getRefuelAmount(tankCapacity, fuelConsumption, distanceAtoB, distanceBtoC);
            System.out.println("Refuel amount: " + refuelAmount + " l");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void printAirplaneInfo(int weight, int capacity, int distanceAtoB, int distanceBtoC, int consumption) {
        System.out.println("Tank Capacity : " + capacity + " l");
        System.out.println("Cargo Weight : " + weight + " kg");
        System.out.println("Fuel Consumption : " + consumption + " l/km");
        System.out.println("Distance from A to B : " + distanceAtoB + " km. Needed fuel amount : " + distanceAtoB * consumption + " l");
        System.out.println("Distance from B to C : " + distanceBtoC + " km. Needed fuel amount : " + distanceBtoC * consumption + " l");
    }

    public static int getFuelConsumption(int weight) throws Exception {
        if (weight > 2000) {
            throw new Exception("More than 2000 kg - the airplane does not lift.");
        } else if (weight >= 1500) {
            return 9;
        } else if (weight >= 1000) {
            return 7;
        } else if (weight >= 500) {
            return 4;
        } else if (weight >= 0) {
            return 1;
        } else {
            throw new Exception("Cargo weight cannot be less than 0.");
        }
    }

    public static int getRefuelAmount(int capacity, int consumption, int distanceAtoB, int distanceBtoC) throws Exception {
        int fuelNeededForAtoB = distanceAtoB * consumption;
        int fuelNeededForBtoC = distanceBtoC * consumption;

        if (capacity < fuelNeededForAtoB) {
            throw new Exception("The airplane can't get from point A to point B. " +
                    "Fuel needed: " + fuelNeededForAtoB + ". Maximum capacity: " + capacity);
        }
        if (capacity < fuelNeededForBtoC) {
            throw new Exception("The airplane can't get from point B to point С. " +
                    "Fuel needed: " + fuelNeededForBtoC + ". Maximum capacity: " + capacity);
        }

        int fuelLeft = capacity - fuelNeededForAtoB;
        if (fuelLeft >= fuelNeededForBtoC) {
            return 0;
        } else {
            return fuelNeededForBtoC - fuelLeft;
        }
    }
}
