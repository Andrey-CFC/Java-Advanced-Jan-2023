package L08StreamsFilesAndDirectoriesEx;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\demo.txt";
        String path2 = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\demo2.txt";
        //1.FileWriter
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("This is demo of file writer.");
        fileWriter.close();

        //2.BufferedWriter
        File fileForBuffered = new File(path2);
        FileWriter fileWriter2 = new FileWriter(fileForBuffered);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter2);
        bufferedWriter.write("This is demo of buffered writer.");
        bufferedWriter.close();


    }
}
