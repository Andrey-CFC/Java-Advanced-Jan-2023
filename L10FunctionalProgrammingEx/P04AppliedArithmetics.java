package L10FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(number -> number + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(number -> number - 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(number -> number * 2).collect(Collectors.toList());
        Consumer<List<Integer>> printList = list -> list.forEach(num -> System.out.print(num + " "));
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    nums = add.apply(nums);
                    break;
                case "multiply":
                    nums = multiply.apply(nums);
                    break;
                case "subtract":
                    nums = subtract.apply(nums);
                    break;
                case "print":
                    printList.accept(nums);
                    System.out.println();
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
