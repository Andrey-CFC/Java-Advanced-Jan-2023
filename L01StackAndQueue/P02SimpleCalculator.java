package L01StackAndQueue;

import java.util.*;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> calculator = new ArrayDeque<>();
        String[] elements = scanner.nextLine().split(" ");
        List<String> elementsList = Arrays.asList(elements);
        Collections.reverse(elementsList);
        for (String element : elementsList) {
            calculator.push(element);
        }
        while (calculator.size()>1){
            int firstEl = Integer.parseInt(calculator.pop());
            String operator = calculator.pop();
            int secondEl = Integer.parseInt(calculator.pop());
            switch (operator){
                case "+":
                    calculator.push(String.valueOf(firstEl+secondEl));
                    break;
                case "-":
                    calculator.push(String.valueOf(firstEl-secondEl));
                    break;
            }
        }
        System.out.println(calculator.peek());
    }
}
