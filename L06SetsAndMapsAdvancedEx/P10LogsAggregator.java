package L06SetsAndMapsAdvancedEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, TreeSet<String>> logsByUser = new TreeMap<>();
        Map<String, Integer> timeOfLogs = new TreeMap<>();

        while (--n >= 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String user = input[1];
            int time = Integer.parseInt(input[2]);

            logsByUser.putIfAbsent(user, new TreeSet<>());
            logsByUser.get(user).add(ip);

            timeOfLogs.putIfAbsent(user, 0);
            timeOfLogs.put(user, timeOfLogs.get(user) + time);
        }

        timeOfLogs.forEach((key, value) -> {
            System.out.println(String.format("%s: %d %s", key, value, logsByUser.get(key).toString()));
        });
    }
}