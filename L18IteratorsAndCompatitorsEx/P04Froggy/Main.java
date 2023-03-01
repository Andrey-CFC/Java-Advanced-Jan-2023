package L18IteratorsAndCompatitorsEx.P04Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Integer[] collection = Arrays.stream(line.split("[\\s,]+")).map(Integer::parseInt).toArray(Integer[]::new);
        Lake lake = new Lake(collection);

        List<String> output = new ArrayList<>();

        for (Integer number : lake) {
            output.add(String.valueOf(number));
        }
        System.out.println(String.join(", ", output));
    }
}
