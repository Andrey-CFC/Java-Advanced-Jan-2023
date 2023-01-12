package L01StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> history = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();
        String currentInput = scanner.nextLine();
        while (!currentInput.equals("Home")) {
            if (currentInput.equals("back")) {
                if (history.size() == 1 || history.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    forward.addFirst(history.pop());
                    System.out.println(history.peek());
                }
            } else if (currentInput.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forward.peek());
                    history.push(forward.poll());
                }
            } else {
                history.push(currentInput);
                forward.clear();
                System.out.println(currentInput);
            }
            currentInput = scanner.nextLine();
        }
    }
}

