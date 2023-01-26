package L10FunctionalProgrammingEx;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Set<String> commandsSequence = new HashSet<>();
        String command = scanner.nextLine();
        while (!command.equals("Print")) {
            String commandName = command.split(";")[0];
            String conditionName = command.split(";")[1];
            String conditionArgument = command.split(";")[2];

            if (commandName.equals("Remove filter")) {
                commandsSequence.remove(conditionName + ";" + conditionArgument);
            } else if (commandName.equals("Add filter")) {
                commandsSequence.add(conditionName + ";" + conditionArgument);;
            }
            command = scanner.nextLine();
        }
        for (String element : commandsSequence) {
            Predicate<String> currentCondition = updateGuests(element.split(";")[0],element.split(";")[1]);
            guestList.removeIf(currentCondition);
        }
        guestList.stream().forEach(person -> System.out.print(person+" "));

    }

    private static Predicate<String> updateGuests(String criteriaName, String criteriaArgument) {
        switch (criteriaName) {
            case "Starts with":
                return s -> s.startsWith(criteriaArgument);
            case "Ends with":
                return s -> s.endsWith(criteriaArgument);
            case "Length":
                return s -> s.length() == Integer.parseInt(criteriaArgument);
            case "Contains":
                return s -> s.contains(criteriaArgument);
            default:
                throw new IllegalArgumentException("Unknown condition " + criteriaName);
        }
    }
}
