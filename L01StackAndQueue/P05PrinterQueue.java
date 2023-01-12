package L01StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentFile = scanner.nextLine();
        Deque<String> files = new ArrayDeque<>();
        while (!currentFile.equals("print")) {
            if (currentFile.equals("cancel")) {
                if (files.size() > 0) {
                    String removedFile = files.remove();
                    System.out.println("Canceled " + removedFile);
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                files.add(currentFile);
            }
            currentFile = scanner.nextLine();
        }
        while (files.size()>0){
            System.out.println(files.remove());
        }
    }
}
