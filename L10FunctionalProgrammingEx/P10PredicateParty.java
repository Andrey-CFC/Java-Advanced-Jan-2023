package L10FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Party!")) {
            String commandName = command.split("\\s+")[0];
            String conditionName = command.split("\\s+")[1];
            String conditionArgument = command.split("\\s+")[2];
            Predicate<String> currentCondition = updateGuests(conditionName, conditionArgument);

            if (commandName.equals("Remove")) {
                guestList.removeAll(guestList.stream().filter(currentCondition).collect(Collectors.toList()));
            } else if (commandName.equals("Double")) {
                guestList.addAll(guestList.stream().filter(currentCondition).collect(Collectors.toList()));
            }
            command = scanner.nextLine();
        }
        if (!guestList.isEmpty()) {
            Collections.sort(guestList);
            for (int i = 0; i < guestList.size(); i++) {
                if (i < guestList.size() - 1) {
                    System.out.print(guestList.get(i) + ", ");
                } else {
                    System.out.print(guestList.get(i) + " are going to the party!");
                }
            }
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static Predicate<String> updateGuests(String criteriaName, String criteriaArgument) {
        switch (criteriaName) {
            case "StartsWith":
                return s -> s.startsWith(criteriaArgument);
            case "EndsWith":
                return s -> s.endsWith(criteriaArgument);
            case "Length":
                return s -> s.length() == Integer.parseInt(criteriaArgument);
            default:
                throw new IllegalArgumentException("Unknown condition " + criteriaName);
        }
    }
}
