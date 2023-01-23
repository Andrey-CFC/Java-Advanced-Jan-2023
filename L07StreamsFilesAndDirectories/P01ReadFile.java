package L07StreamsFilesAndDirectories;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P01ReadFile {
    public static void main(String[] args) {
        String path = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (FileInputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte>=0){
                System.out.print(Integer.toBinaryString(oneByte)+" ");
                oneByte = in.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        InputStream inputStream = new FileInputStream(path);
//        int oneByte = inputStream.read();
//        System.out.println(oneByte);
//        System.out.println((char) oneByte);
//        inputStream.close();
    }
}
