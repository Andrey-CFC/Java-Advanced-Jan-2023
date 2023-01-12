package L01StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int rounds = Integer.parseInt(scanner.nextLine());
        Deque<String> queue = new ArrayDeque<>();
        for (String child : children) {
            queue.offer(child);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < rounds; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}

