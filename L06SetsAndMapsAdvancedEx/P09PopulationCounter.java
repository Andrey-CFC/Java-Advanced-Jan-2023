package L06SetsAndMapsAdvancedEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> countryMap = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countriesPopulation = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("report")) {
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            Long population = Long.parseLong(input.split("\\|")[2]);

            if (countriesPopulation.containsKey(country)) {
                countriesPopulation.put(country, countriesPopulation.get(country) + population);
            } else {
                countriesPopulation.put(country, population);
            }
            countryMap.putIfAbsent(country, new LinkedHashMap<>());
            countryMap.get(country).put(city, population);

            input = scanner.nextLine();
        }

        countriesPopulation.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEach(place -> {
                    System.out.println(place.getKey() + " (total population: " + place.getValue() + ")");
                    String country = place.getKey();
                    countryMap.get(country).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEach(city ->
                            System.out.println("=>" + city.getKey() + ": " + city.getValue()));
                });
    }
}
