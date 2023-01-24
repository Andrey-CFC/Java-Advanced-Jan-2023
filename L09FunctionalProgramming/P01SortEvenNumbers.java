package L09FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(element -> Integer.parseInt(element))
                .collect(Collectors.toList());
        numbers.removeIf(num -> num % 2 != 0);
        if (!numbers.isEmpty()) {
            if (numbers.size() > 1) {
                for (int i = 0; i < numbers.size() - 1; i++) {
                    System.out.print(numbers.get(i) + ", ");
                }
            }
            System.out.print(numbers.get(numbers.size() - 1));
            System.out.println();
            List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
            if (sortedNumbers.size() > 1) {
                for (int i = 0; i < sortedNumbers.size() - 1; i++) {
                    System.out.print(sortedNumbers.get(i) + ", ");
                }
            }
            System.out.print(sortedNumbers.get(sortedNumbers.size() - 1));
        }
    }
}
