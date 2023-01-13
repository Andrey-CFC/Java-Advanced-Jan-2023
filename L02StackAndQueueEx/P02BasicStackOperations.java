package L02StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); //брой на елементите за добавяне в стека
        int s = scanner.nextInt(); //брой на елементите за премахване в стека
        int x = scanner.nextInt(); //число за проверка за наличност

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= n ; i++) {
            stack.push(scanner.nextInt());
        }
        for (int i = 1; i <= s ; i++) {
            stack.pop();
        }
        if (stack.contains(x)){
            System.out.println("true");
        } else if (!stack.isEmpty()){
            System.out.println(Collections.min(stack));
        } else {
            System.out.println("0");
        }
    }
}
