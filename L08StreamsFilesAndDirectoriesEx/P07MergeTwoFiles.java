package L08StreamsFilesAndDirectoriesEx;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String inputOne = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt";
        String inputTwo = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt";
        String output = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\output7.txt";
        PrintWriter writer = new PrintWriter(output);

        List<String> allLines = Files.readAllLines(Path.of(inputOne));
        for (String line : allLines) {
            writer.println(line);
        }
        List<String> allLinesTwo = Files.readAllLines(Path.of(inputTwo));
        for (String line : allLinesTwo) {
            writer.println(line);
        }
        writer.close();
    }
}
