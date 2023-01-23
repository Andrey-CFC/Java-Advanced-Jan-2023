package L07StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\04_output.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintStream writer = new PrintStream(new FileOutputStream(outputPath));

        while (reader.hasNext()){
            if (reader.hasNextInt()){
                writer.println(reader.nextInt());
            }
            reader.next();
        }
        writer.close();
    }
}
