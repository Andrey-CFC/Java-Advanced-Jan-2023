package L02StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            if (command.startsWith("1")) {
                stack.push(text.toString());
                String textToAppend = command.split("\\s+")[1];
                text.append(textToAppend);
            } else if (command.startsWith("2")) {
                stack.push(text.toString());
                int count = Integer.parseInt(command.split("\\s+")[1]);
                text.delete(text.length() - count, text.length());
            } else if (command.startsWith("3")) {
                int positionToPrint = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(text.charAt(positionToPrint - 1));
            } else if (command.equals("4")) {
                text.replace(0, text.length() , stack.pop());
            }
        }
    }
}
