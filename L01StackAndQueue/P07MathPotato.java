package L01StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int rounds = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> kids = new PriorityQueue<>();
        for (String child : children) {
            kids.offer(child);
        }
        int cycle = 1;
        while (kids.size() > 1) {
            for (int i = 1; i < rounds; i++) {
                kids.offer(kids.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + kids.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle == 1){
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}