package L05SetsAndMapsAdvanced;

import java.util.*;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayerDeck = new LinkedHashSet<>();
        Set<Integer> secondPlayerDeck = new LinkedHashSet<>();
        int[] firstDeck = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondDeck = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 20; i++) {
            firstPlayerDeck.add(firstDeck[i]);
            secondPlayerDeck.add(secondDeck[i]);
        }
        int hands = 1;
        for (int i = 1; i <= 50; i++) {
            if (firstPlayerDeck.isEmpty()) {
                break;
            }
            if (secondPlayerDeck.isEmpty()) {
                break;
            }

            int fighterOne = firstPlayerDeck.iterator().next();
            int fighterTwo = secondPlayerDeck.iterator().next();
            firstPlayerDeck.remove(fighterOne);
            secondPlayerDeck.remove(fighterTwo);
            if (fighterOne > fighterTwo) {
                firstPlayerDeck.add(fighterOne);
                firstPlayerDeck.add(fighterTwo);
            } else if (fighterOne < fighterTwo) {
                secondPlayerDeck.add(fighterOne);
                secondPlayerDeck.add(fighterTwo);
            } else {
                firstPlayerDeck.add(fighterOne);
                secondPlayerDeck.add(fighterTwo);
            }
            hands++;
        }
        if (firstPlayerDeck.size() < secondPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else if (secondPlayerDeck.size()< firstPlayerDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
