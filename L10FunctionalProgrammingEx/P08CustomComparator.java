package L10FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (e1, e2) -> {
            if (e1 % 2 == 0 && e2 % 2 != 0) {
                return -1;
            } else if (e1 % 2 != 0 && e2 % 2 == 0) {
                return 1;
            }
            return e1.compareTo(e2);
        };
        nums.stream().sorted(comparator).forEach(num -> System.out.print(num + " "));
    }
}
