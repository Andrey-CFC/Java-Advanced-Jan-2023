package L18IteratorsAndCompatitorsEx.P02Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ListyIterator<String> listyIterator = new ListyIterator<String>();
        while (!line.equals("END")) {
            String[] parameters = line.split("\\s+");
            switch (parameters[0]) {
                case "Create":
                    if (parameters.length > 1) {
                        listyIterator = new ListyIterator<>(Arrays.copyOfRange(parameters, 1, parameters.length));
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
