package L06SetsAndMapsAdvancedEx;

import java.util.*;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> chars = new TreeMap<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            chars.putIfAbsent(input.charAt(i), 0);
            chars.put(input.charAt(i), chars.get(input.charAt(i)) + 1);
        }
        chars.forEach((letter, count) -> System.out.println(letter + ": " + count + " time/s"));
    }
}
