package L06SetsAndMapsAdvancedEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String phone = input.split("-")[1];
            phonebook.put(name, phone);
            input = scanner.nextLine();
        }
        String searchName = scanner.nextLine();
        while (!searchName.equals("stop")) {
            if (phonebook.containsKey(searchName)) {
                System.out.println(searchName + " -> " + phonebook.get(searchName));
            } else {
                System.out.println("Contact " + searchName + " does not exist.");
            }
            searchName = scanner.nextLine();
        }
    }
}
