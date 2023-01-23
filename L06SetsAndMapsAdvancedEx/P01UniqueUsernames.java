package L06SetsAndMapsAdvancedEx;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> words = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (--n >= 0) {
            String currentWord = scanner.nextLine();
            if (!words.contains(currentWord)) {
                words.add(currentWord);
            }
        }
        words.forEach(System.out::println);
    }
}
