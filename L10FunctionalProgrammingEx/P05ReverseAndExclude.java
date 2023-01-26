package L10FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(nums);
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> checkDivisibleNum = num -> num % n == 0;
        nums.removeIf(checkDivisibleNum);
        nums.forEach(num -> System.out.print(num + " "));
    }
}
