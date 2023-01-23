package L08StreamsFilesAndDirectoriesEx;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        //начин 1
        int vowels = 0;
        int otherSymbols = 0;
        int punctuation = 0;
        List<String> allLines = Files.readAllLines(Path.of(inputPath));

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                if ((int) symbol == 97 || (int) symbol == 101 || (int) symbol == 105 || (int) symbol == 111 || (int) symbol == 117) {
                    vowels++;
                } else if ((int) symbol == 33||(int) symbol == 44||(int) symbol == 46||(int) symbol == 63){
                    punctuation++;
                } else if ((int) symbol != 32){
                    otherSymbols++;
                }
            }
        }
        writer.write("Vowels: " + vowels);
        writer.newLine();
        writer.write("Other symbols: " + otherSymbols);
        writer.newLine();
        writer.write("Punctuation: " + punctuation);

        writer.close();
    }
}
