package L08StreamsFilesAndDirectoriesEx;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        //начин 1
//        List<String> allLines = Files.readAllLines(Path.of(inputPath));
//        for (String line :allLines) {
//            writer.write(line.toUpperCase());
//            writer.newLine();
//        }
//        writer.close();

        //начин 2
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase());
            writer.newLine();

            line = reader.readLine();
        }
        writer.close();
    }
}
