package L10FunctionalProgrammingEx;

import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        //начин 1
//        for (String name : names) {
//            System.out.println(name);
//        }
        //начин 2
//        Consumer<String> printName = name -> System.out.println(name);
//        for (String name : names) {
//            printName.accept(name);
//        }
        //начин 3
        Consumer<String[]> printArray = array -> {
            for (String name:array) {
                System.out.println(name);
            }
        };
        printArray.accept(names);
    }
}
