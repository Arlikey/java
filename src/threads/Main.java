package threads;

import iofiles.censor.Censor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    private static Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        //rand_array_thread();
        //files_thread();
        //copy_directory();
        merge_files();
    }

    private static void rand_array_thread() throws InterruptedException {
        int[] array = new int[10];

        Thread fillThread = new Thread(() -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = rand.nextInt(100);
            }
        });

        fillThread.start();

        AtomicInteger sumResult = new AtomicInteger();
        Thread sumThread = new Thread(() -> {
            int sum = 0;
            for (int n : array) sum += n;
            sumResult.set(sum);
        });

        AtomicReference<Double> avgResult = new AtomicReference<>((double) 0);
        Thread avgThread = new Thread(() -> {
            int sum = 0;
            for (int n : array) sum += n;
            avgResult.set(sum / (double) array.length);
        });

        fillThread.join();

        sumThread.start();
        avgThread.start();

        sumThread.join();
        avgThread.join();

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Sum: " + sumResult);
        System.out.println("Average: " + avgResult);
    }

    private static void files_thread() throws InterruptedException {
        Path numbersFile = Path.of("numbers.txt");
        Path primesFile = Path.of("primes.txt");
        Path factorialsFile = Path.of("factorials.txt");

        Thread numbersWriterThread = new Thread(() -> {
            StringBuilder numbers = new StringBuilder();
            for (int i = 0; i < 10000; i++) {
                numbers.append(rand.nextInt(100)).append(" ");
            }
            try {
                Files.writeString(numbersFile, numbers.toString().trim());
            } catch (IOException e) {
                e.getMessage();
            }
        });

        numbersWriterThread.start();
        numbersWriterThread.join();

        Thread primeThread = new Thread(() -> {
            var start = System.currentTimeMillis();
            try {
                String content = Files.readString(numbersFile);
                StringBuilder primes = new StringBuilder();
                for (String s : content.split("\\s+")) {
                    int n = Integer.parseInt(s);
                    boolean prime = n >= 2;
                    for (int i = 2; i * i < n; i++) {
                        if (n % i == 0) {
                            prime = false;
                            break;
                        }
                    }
                    if (prime) primes.append(n).append(" ");
                }
                Files.writeString(primesFile, primes.toString().trim());
            } catch (IOException e) {
                e.getMessage();
            }
            long end = System.currentTimeMillis();
            System.out.println("Prime thread time: " + (end - start) + " ms");
        });

        Thread factorialThread = new Thread(() -> {
            var start = System.currentTimeMillis();
            try {
                String content = Files.readString(numbersFile);
                StringBuilder factorials = new StringBuilder();
                for (String s : content.split("\\s+")) {
                    int n = Integer.parseInt(s);
                    long fact = 1;
                    for (int i = 2; i <= n; i++) fact *= i;
                    factorials.append(fact).append("\n");
                }
                Files.writeString(factorialsFile, factorials.toString());
            } catch (IOException e) {
                e.getMessage();
            }
            long end = System.currentTimeMillis();
            System.out.println("Factorial thread time: " + (end - start) + " ms");
        });

        primeThread.start();
        factorialThread.start();

        primeThread.join();
        factorialThread.join();
    }

    private static void copy_directory() throws InterruptedException {
        Path source = Path.of("src/iofiles");
        Path target = Path.of("src/threads/iofiles");

        Runnable task = () -> {
            int filesCopied = 0;
            int dirsCreated = 0;

            try (var paths = Files.walk(source)) {
                for (Path path : (Iterable<Path>) paths::iterator) {
                    Path relative = source.relativize(path);
                    Path targetPath = target.resolve(relative);

                    if (Files.isDirectory(path)) {
                        if (!Files.exists(targetPath)) {
                            try {
                                Files.createDirectories(targetPath);
                                dirsCreated++;
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    } else {
                        try {
                            Files.copy(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
                            filesCopied++;
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                System.out.println("Files copied: " + filesCopied);
                System.out.println("Directories created: " + dirsCreated);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        };

        Thread copyThread = new Thread(task);
        copyThread.start();
        copyThread.join();
    }

    private static void merge_files() throws InterruptedException {
        Path dir = Path.of("src/threads/files/");
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter word to search: ");
        String word = scan.nextLine().trim();

        Path merged = Path.of("src/threads/files/output/merged.txt");
        Path banwords = Path.of("src/threads/files/output/banned.txt");

        AtomicInteger foundFilesCount = new AtomicInteger();

        Thread searchThread = new Thread(() -> {
            try {
                List<Path> files = Files.list(dir)
                        .filter(Files::isRegularFile)
                        .filter(f -> {
                            try {
                                return Files.readString(f).contains(word);
                            } catch (IOException e) {
                                return false;
                            }
                        })
                        .toList();

                StringBuilder mergedContent = new StringBuilder();
                for (Path f : files) {
                    mergedContent.append(Files.readString(f)).append("\n");
                }
                Files.writeString(merged, mergedContent.toString());
                foundFilesCount.set(files.size());

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread filterThread = new Thread(() -> {
            try {
                searchThread.join();
                String[] banWords = Files.readString(banwords).trim().split("[\\s,;]+");
                Censor.censor(merged, banWords);
            } catch (IOException | InterruptedException e) {
                System.out.println("Error in filterThread: " + e.getMessage());
            }
        });

        searchThread.start();
        filterThread.start();

        searchThread.join();
        filterThread.join();

        System.out.println("Found files containing the word: " + foundFilesCount.get());
    }
}
