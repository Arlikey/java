package iofiles;

import iofiles.corporation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static String directory = "src/iofiles/files/";

    public static void main(String[] args) {
        //string_equality();
        //longest_str_in_file();
        //array_in_file();
        //censor();
        corporation();
    }

    private static void string_equality() {
        Path filePath1 = Path.of(directory + "song.txt");
        Path filePath2 = Path.of(directory + "song2.txt");

        try {
            if (Arrays.equals(Files.readAllBytes(filePath1), Files.readAllBytes(filePath2))) {
                System.out.println("Files equals");
            } else {
                List<String> fileStrings1 = Files.readAllLines(filePath1);
                List<String> fileStrings2 = Files.readAllLines(filePath2);

                int maxLines = Math.max(fileStrings1.size(), fileStrings2.size());

                System.out.println("Differences found:");

                for (int i = 0; i < maxLines; i++) {
                    String line1 = i < fileStrings1.size() ? fileStrings1.get(i) : "<no line>";
                    String line2 = i < fileStrings2.size() ? fileStrings2.get(i) : "<no line>";

                    if (!line1.equals(line2)) {
                        System.out.println("Line " + (i + 1) + ":");
                        System.out.println("  File 1: " + line1);
                        System.out.println("  File 2: " + line2);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static void longest_str_in_file() {
        String fileName = "song.txt";
        try {
            List<String> strings = Files.readAllLines(Path.of(directory + fileName));

            Optional<String> longestString = strings.stream().max(Comparator.comparingInt(String::length));

            longestString.ifPresent(str -> System.out.println("Length: " + str.length() + "\n" + str));
        } catch (IOException e) {
            System.out.println("Something went wrong while reading: " + e.getMessage());
        }
    }

    private static void array_in_file() {
        String fileName = "output.txt";
        String[] userInput = null;
        int[] array = null;
        while (true) {
            try {
                System.out.print("Enter array of numbers, example 1, 3, 8, -2: ");
                userInput = scan.nextLine().trim().split("[\\s,;]+");

                array = Arrays.stream(userInput).mapToInt(Integer::parseInt).toArray();

                break;
            } catch (Exception e) {
                System.out.println("Incorrect input. Try again!");
            }
        }

        String initArray = Arrays.toString(array);
        String arrayOfEvens = Arrays.toString(Arrays.stream(array).filter(x -> x % 2 == 0).toArray());
        String arrayOfOdds = Arrays.toString(Arrays.stream(array).filter(x -> x % 2 != 0).toArray());
        int[] reversed = new int[array.length];

        int i = 0;
        for (int x : array)
            reversed[array.length - ++i] = x;
        String reversedArray = Arrays.toString(reversed);

        try {
            Files.write(Path.of(directory + fileName), List.of(initArray, arrayOfEvens, arrayOfOdds, reversedArray));
            System.out.println("Data successfully written in " + fileName);
        } catch (IOException e) {
            System.out.println("Something went wrong during writing: " + e.getMessage());
        }
    }

    private static void censor() {
        String fileName = "words.txt";
        System.out.print("Enter list of ban words: ");
        String[] banWords = scan.nextLine().trim().split("[\\s,;]+");

        Map<String, Integer> wordCount = new HashMap<>();

        try {
            String fileText = Files.readString(Path.of(directory + fileName));

            for (String word : banWords) {
                int count = 0;

                String replacement = "*".repeat(word.length());

                while (fileText.toLowerCase().contains(word.toLowerCase())) {
                    fileText = fileText.replaceFirst("(?i)" + word, replacement);
                    count++;
                }

                if (count > 0) {
                    wordCount.put(word, count);
                }
            }

            Files.writeString(Path.of(directory + fileName), fileText);

            int total = 0;
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println("\"" + entry.getKey() + "\" censored: " + entry.getValue() + " times");
                total += entry.getValue();
            }
            System.out.println("Total censored words: " + total);

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static void corporation() {
        CorporationConsole corporationTerminal = new CorporationConsole(new CorporationService(new Corporation()));
        corporationTerminal.start();
    }
}
