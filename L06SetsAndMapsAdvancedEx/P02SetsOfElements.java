package L06SetsAndMapsAdvancedEx;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split("\\s+")[0]);
        int m = Integer.parseInt(input.split("\\s+")[1]);
        for (int i = 1; i <= n; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            set1.add(currentNum);
        }
        for (int i = 1; i <= m; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            set2.add(currentNum);
        }
        set1.retainAll(set2);
        set1.forEach(element-> System.out.print(element+" "));
    }
}
