package L10FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        //начин 1
//        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
//        Predicate<String> checkLength = name -> name.length() > n;
//        names.removeIf(checkLength);
//        names.forEach(System.out::println);
        //начин 2
        String[] names = scanner.nextLine().split("\\s+");
        Predicate<String> checkValidLength = name -> name.length() <= n;
        Arrays.stream(names).filter(checkValidLength).forEach(System.out::println);
    }
}
