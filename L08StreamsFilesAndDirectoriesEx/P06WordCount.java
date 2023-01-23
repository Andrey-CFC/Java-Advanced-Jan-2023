package L08StreamsFilesAndDirectoriesEx;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P06WordCount {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt";
        String secondPath = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt";
        String outputPath = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\results.txt";
        List<String> allLinesWithWords = Files.readAllLines(Path.of(inputPath));

        Map<String, Integer> wordsCounter = new TreeMap<>();
        for (String line : allLinesWithWords) {
            String[] wordsOfCurrentRow = line.split("\\s+");
            Arrays.stream(wordsOfCurrentRow).forEach(word -> {
                wordsCounter.put(word, 0);
            });
        }
        List<String> allLinesWithText = Files.readAllLines(Path.of(secondPath));
        for (String line: allLinesWithText) {
            String[] words = line.split("\\s+");
            for (String word:words) {
                if (wordsCounter.containsKey(word)){
                    wordsCounter.put(word,wordsCounter.get(word)+1);
                }
            }
        }
        PrintWriter writer = new PrintWriter(outputPath);
        wordsCounter.entrySet().stream().sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry->writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
