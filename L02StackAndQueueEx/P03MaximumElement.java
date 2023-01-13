package L02StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            if (x == 1) {
                int y = scanner.nextInt();
                stack.push(y);
            } else if (x == 2) {
                stack.pop();
            } else if (x == 3) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
