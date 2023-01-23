package L08StreamsFilesAndDirectoriesEx;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {
        String inputFile = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputFile = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output5.txt";
        List<String> allLines = Files.readAllLines(Path.of(inputFile));

        PrintWriter writer = new PrintWriter(outputFile);
        int lineNum = 1;
        for (String line : allLines) {
            writer.println(lineNum + ". " + line);
            lineNum++;
        }
        writer.close();
    }
}
