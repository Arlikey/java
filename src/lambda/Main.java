package lambda;

import lambda.date.ITimeBetween;
import lambda.math.ArrayUtil;
import lambda.television.Television;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //date();

        //math();

        television();
    }

    public static void date() {
        Predicate<LocalDate> isLeap = (date) -> {
            int year = date.getYear();
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        };

        LocalDate dateInPast = LocalDate.of(2012, 5, 12);

        System.out.println(isLeap.test(LocalDate.now()));
        System.out.println(isLeap.test(dateInPast));

        ITimeBetween<LocalDate, Long> countOfDays = ChronoUnit.DAYS::between;
        System.out.println(countOfDays.test(dateInPast, LocalDate.now()) + " days");

        ITimeBetween<LocalDate, Long> countOfWeeks = ChronoUnit.WEEKS::between;
        System.out.println(countOfWeeks.test(dateInPast, LocalDate.now()) + " weeks");

        Function<LocalDate, DayOfWeek> dayOfWeek = LocalDate::getDayOfWeek;
        System.out.println(dayOfWeek.apply(LocalDate.now()));
    }

    public static void math() {
        Integer[] array = new Integer[15];

        ArrayUtil.fillArray(array, -20, 40);

        System.out.println(Arrays.toString(array));
        int equalsNumber = 12;
        System.out.println("Sum of " + equalsNumber + "'s: " + getSumOfElements(array, number -> number == equalsNumber));

        int from = -10, to = 20;
        System.out.println("Sum of elements not between from " + from + " to " + to + ": " + getSumOfElements(array, number -> number <= from || number >= to));
        System.out.println("Sum of positives: " + getSumOfElements(array, number -> number > 0));
        System.out.println("Sum of negatives: " + getSumOfElements(array, number -> number < 0));
    }

    public static <T extends Number> int getSumOfElements(T[] array, Predicate<T> lambda) {
        int sum = 0;
        for (T i : array)
            if (lambda.test(i)) sum += i.intValue();
        return sum;
    }

    public static void television() {
        List<Television> tvList = List.of(
                new Television("OLED CX", 2023, 1199.99, 55, 120, "LG", true),
                new Television("QLED Q90T", 2024, 1399.99, 65, 120, "Samsung", true),
                new Television("Bravia X90J", 2022, 999.99, 55, 120, "Sony", true),
                new Television("Crystal UHD 7", 2023, 549.99, 43, 60, "Samsung", true),
                new Television("NanoCell 80", 2021, 799.99, 50, 60, "LG", true),
                new Television("Xiaomi Mi TV P1", 2024, 399.99, 43, 60, "Xiaomi", true),
                new Television("BudgetBox 32", 2024, 189.99, 32, 60, "Hisense", false)
        );


        int currentYear = LocalDate.now().getYear();

        System.out.println("\nAll TV's:");
        tvList.forEach(System.out::println);

        double diagonal = 50;
        System.out.println("\nTV's with diagonal " + diagonal + "\":");
        tvList.stream()
                .filter(tv -> tv.getDiagonal() == diagonal)
                .forEach(System.out::println);

        String brand = "Samsung";
        System.out.println("\nTV's of manufacturer: " + brand);
        tvList.stream()
                .filter(tv -> tv.getManufacturer().equalsIgnoreCase(brand))
                .forEach(System.out::println);

        System.out.println("\nTV's of current year (" + currentYear + "):");
        tvList.stream()
                .filter(tv -> tv.getYear() == currentYear)
                .forEach(System.out::println);

        double minPrice = 800.0;
        System.out.println("\nMore expensive than $" + minPrice + ":");
        tvList.stream()
                .filter(tv -> tv.getPrice() > minPrice)
                .forEach(System.out::println);

        System.out.println("\nSorted by price ascending:");
        tvList.stream()
                .sorted(Comparator.comparingDouble(Television::getPrice))
                .forEach(System.out::println);

        System.out.println("\nSorted by price descending:");
        tvList.stream()
                .sorted(Comparator.comparingDouble(Television::getPrice).reversed())
                .forEach(System.out::println);

        System.out.println("\nSorted by diagonal ascending:");
        tvList.stream()
                .sorted(Comparator.comparingDouble(Television::getDiagonal))
                .forEach(System.out::println);

        double minDiagonal = 40;
        double minRefreshRate = 60;
        boolean isSmart = true;
        double maxPrice = 800;

        List<Television> filtered = tvList.stream()
                .filter(tv -> tv.getDiagonal() >= minDiagonal)
                .filter(tv -> tv.getRefreshRate() >= minRefreshRate)
                .filter(tv -> !isSmart || tv.isSmartTV())
                .filter(tv -> tv.getPrice() <= maxPrice)
                .sorted(Comparator.comparingDouble(Television::getScore))
                .toList();

        System.out.println("\nSorted by user characteristics:");
        if (filtered.isEmpty()) {
            System.out.println("Filtered list is empty.");
        } else {
            System.out.println("Worst TV:");
            System.out.println(filtered.getFirst() + " score: " + filtered.getFirst().getScore());

            if (filtered.size() > 1) {
                System.out.println("Best TV:");
                System.out.println(filtered.getLast() + " score: " + filtered.getLast().getScore());
            }
        }

    }
}


