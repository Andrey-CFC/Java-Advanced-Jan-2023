package L18IteratorsAndCompatitorsEx.P06StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> nameSet = new TreeSet<>(new ComparatorByName());
        Set<Person> ageSet = new TreeSet<>(new ComparatorByAge());

        int rows = Integer.parseInt(scanner.nextLine());
        while (--rows >= 0) {
            String[] personalData = scanner.nextLine().split("\\s+");
            Person person = new Person(personalData[0], Integer.parseInt(personalData[1]));
            nameSet.add(person);
            ageSet.add(person);
        }
        for (Person person : nameSet) {
            System.out.println(person);
        }
        for (Person person : ageSet) {
            System.out.println(person);
        }
    }
}
