package L07StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08NestedFolders {
    public static void main(String[] args) {
        String folderPath = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(folderPath);
        Deque<File> directories = new ArrayDeque<>();
        directories.offer(root);
        int count = 0;
        while (!directories.isEmpty()) {
            File currentDirectory = directories.poll();
            File[] nestedFiles = currentDirectory.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    directories.offer(nestedFile);
            count++;
            System.out.println(currentDirectory.getName());
        }
        System.out.println(count + " folders");
    }
}
