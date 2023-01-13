package L02StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        long n = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(fibonacci,n));
    }

    private static Long getFibonacci(ArrayDeque<Long> fibonacci, long n) {
        if (n<2){
            return 1L;
        } else {
            fibonacci.offer(0L);
            fibonacci.offer(1L);
            for (int i = 0; i < n; i++) {
                fibonacci.offer(fibonacci.poll()+fibonacci.peek());
            }
        }
        fibonacci.poll();
        return fibonacci.peek();
    }
}
