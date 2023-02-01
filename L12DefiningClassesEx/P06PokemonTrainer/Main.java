package L12DefiningClassesEx.P06PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Map<String, List<Pokemon>> pokemonByTrainers = new LinkedHashMap<>();

        while (!inputLine.equals("Tournament")) {
            String[] data = inputLine.split("\\s+");
            Pokemon pokemon = new Pokemon(data[1], data[2], Integer.parseInt(data[3]));
            pokemonByTrainers.putIfAbsent(data[0], new ArrayList<>());
            pokemonByTrainers.get(data[0]).add(pokemon);
            inputLine = scanner.nextLine();
        }
        List<Trainer> trainers = pokemonByTrainers.entrySet().stream().map(trainer -> new Trainer(trainer.getKey(),trainer.getValue())).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")){
            for (Trainer trainer: trainers) {
                trainer.executionOfCommand(command);
            }
            command = scanner.nextLine();
        }
        trainers.stream().sorted(Comparator.comparingInt(Trainer::getBadges).reversed()).forEach(System.out::println);
    }
}
