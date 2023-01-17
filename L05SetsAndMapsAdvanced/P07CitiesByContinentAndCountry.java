package L05SetsAndMapsAdvanced;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> countriesByContinent = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];
            countriesByContinent.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> citiesByCountry = countriesByContinent.get(continent);
            citiesByCountry.putIfAbsent(country, new ArrayList<>());
            citiesByCountry.get(country).add(city);
        }
        countriesByContinent.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    entry.getValue().entrySet().stream()
                            .forEach(country -> {
                                String output = String.join(", ", country.getValue());
                                System.out.println(" " + country.getKey() + " -> " + output);
                            });
                });
    }
}
