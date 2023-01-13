package L02StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        ArrayDeque<Character> stackOpenBrackets = new ArrayDeque<>();
        boolean right = false;
        for (char bracket : expression.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stackOpenBrackets.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (stackOpenBrackets.isEmpty()) {
                    right = false;
                    break;
                } else {
                    char lastOpenBracket = stackOpenBrackets.pop();
                    if (lastOpenBracket == '(' && bracket == ')') {
                        right = true;
                    } else if (lastOpenBracket == '[' && bracket == ']') {
                        right = true;
                    } else if (lastOpenBracket == '{' && bracket == '}') {
                        right = true;
                    } else {
                        right = false;
                        break;
                    }
                }
            }
        }
        if (!right) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
