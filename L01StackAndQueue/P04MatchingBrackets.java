package L01StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch=='('){
                stack.push(i);
            } else if (ch==')'){
                int startIndex = stack.pop();
                String brackets = expression.substring(startIndex,i+1);
                System.out.println(brackets);
            }
        }
    }
}
