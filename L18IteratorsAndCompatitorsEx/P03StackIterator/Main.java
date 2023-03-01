package L18IteratorsAndCompatitorsEx.P03StackIterator;

import javax.naming.OperationNotSupportedException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        StackIterator stack = new StackIterator();
        while (!line.equals("END")) {
            String[] parameters = line.split("[\\s,]+");
            switch (parameters[0]) {
                case "Push":
                    for (int i = 1; i < parameters.length; i++) {
                        stack.push(Integer.parseInt(parameters[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (OperationNotSupportedException ex) {
                        System.out.println("No elements");
                    }
                    break;
            }
            line = scanner.nextLine();
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}
