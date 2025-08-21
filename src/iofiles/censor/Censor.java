package iofiles.censor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Censor {
    public static void censor(Path filePath, String[] banWords) {
        Map<String, Integer> wordCount = new HashMap<>();
        try {
            String content = Files.readString(filePath);

            for (String word : banWords) {
                int count = 0;
                String replacement = "*".repeat(word.length());

                while (content.toLowerCase().contains(word.toLowerCase())) {
                    content = content.replaceFirst("(?i)" + word, replacement);
                    count++;
                }

                if (count > 0) wordCount.put(word, count);
            }

            Files.writeString(filePath, content);

            int total = wordCount.values().stream().mapToInt(Integer::intValue).sum();
            for (var entry : wordCount.entrySet()) {
                System.out.println("\"" + entry.getKey() + "\" censored: " + entry.getValue() + " times");
            }
            System.out.println("Total censored words: " + total);

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
