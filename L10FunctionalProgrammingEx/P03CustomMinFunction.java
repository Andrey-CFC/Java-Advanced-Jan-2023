package L10FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        //начин 1
//        System.out.println(Collections.min(nums));
        //начин 2
//        Consumer<List<Integer>> printMinNum = list -> System.out.println(Collections.min(list));
//        printMinNum.accept(nums);
        //начин 3
        Function<List<Integer>,Integer> getMinNumber = list -> Collections.min(list);
        System.out.println(getMinNumber.apply(nums));
    }
}
