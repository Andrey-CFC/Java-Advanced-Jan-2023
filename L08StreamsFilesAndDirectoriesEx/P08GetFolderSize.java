package L08StreamsFilesAndDirectoriesEx;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {
        String folderPath = "D:\\Andrey\\Courses\\Java Advanced\\Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(folderPath);

        File[] allFilesInFolder = folder.listFiles();
        int folderSize = 0;
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
        }
        System.out.println("Folder size: " + folderSize);
    }
}
