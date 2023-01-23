package L08StreamsFilesAndDirectoriesEx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P02umBytes {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        //начин 1
//        long sum = 0;
//        for (String line : allLines) {
//            for (char symbol : line.toCharArray()) {
//                sum += (int) symbol;
//            }
//        }
//        System.out.println(sum);
        //начин 2
        byte[] allBytes = Files.readAllBytes(Path.of(path));
        long sum = 0;
        for (byte ascii : allBytes) {
            if (ascii != 13 && ascii != 10) {
            sum+=ascii;
            }
        }
        System.out.println(sum);
    }
}