package L02StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> operators = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String currentOperator = input[i];
            switch (currentOperator) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                case "(":
                    if (operators.isEmpty() || hasLowerPriority(operators.peek(), currentOperator)) {
                        operators.push(currentOperator);
                    } else {
                        while (!hasLowerPriority(operators.peek(), currentOperator)) {
                            System.out.print(operators.pop() + " ");
                            if (operators.isEmpty()) {
                                break;
                            }
                        }
                        operators.push(currentOperator);
                    }
                    break;
                case ")":
                    while (!operators.peek().equals("(")) {
                        System.out.print(operators.pop() + " ");
                    }
                    operators.pop();
                    break;
                default:
                    System.out.print(currentOperator + " ");
            }
        }
        while (!operators.isEmpty()) {
            System.out.print(operators.pop() + " ");
        }
    }
    private static boolean hasLowerPriority(String current, String next) {
        int currentOperatorPriority = priority(current);
        int nextOperatorPriority = priority(next);
        if (currentOperatorPriority < nextOperatorPriority) {
            return true;
        } else if (currentOperatorPriority == nextOperatorPriority) {
            if (currentOperatorPriority == 3 || currentOperatorPriority == 4) {
                return true;
            } else {
                return false;
            }
        } else {
            if (currentOperatorPriority == 4) {
                return true;
            } else {
                return false;
            }
        }
    }
    private static int priority(String operator) {
        int priority = 0;
        if (operator.equals("+") || operator.equals("-")) {
            priority = 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            priority = 2;
        } else if (operator.equals("^")) {
            priority = 3;
        } else if (operator.equals("(")) {
            priority = 4;
        }
        return priority;
    }
}
