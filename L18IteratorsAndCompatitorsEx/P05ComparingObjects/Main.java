package L18IteratorsAndCompatitorsEx.P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("END")) {
            String[] personalInfo = input.split("\\s+");
            Person person = new Person(personalInfo[0], Integer.parseInt(personalInfo[1]), personalInfo[2]);
            people.add(person);
            input = scanner.nextLine();
        }
        int indexOfPerson = Integer.parseInt(scanner.nextLine());
        int counterSame = 0;
        int counterDifferent = 0;
        Person personToCompare = people.get(indexOfPerson - 1);

        for (Person person : people) {
            if (person.compareTo(personToCompare) == 0) {
                counterSame++;
            } else {
                counterDifferent++;
            }
        }
        if (counterSame == 1) {
            System.out.println("No matches");
        } else {
            System.out.print(counterSame + " " + counterDifferent + " " + people.size());
        }
    }
}
