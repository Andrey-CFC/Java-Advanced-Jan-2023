package L06SetsAndMapsAdvancedEx;

import java.util.*;
import java.util.stream.Collectors;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> cardsByPlayer = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String name = input.split(":")[0];
            cardsByPlayer.putIfAbsent(name, new ArrayList<>());
            String inputByName = input.split(":")[1];
            List<String> cards = Arrays.stream(inputByName.split(",")).collect(Collectors.toList());
            for (int i = 0; i < cards.size(); i++) {
                if (!cardsByPlayer.get(name).contains(cards.get(i).trim())) {
                   cardsByPlayer.get(name).add(cards.get(i).trim());
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> player : cardsByPlayer.entrySet()) {
            int value = getValueOfPlayersCards(player.getValue());
            System.out.println(player.getKey() + ": " + value);
        }

    }

    private static int getValueOfPlayersCards(List<String> cards) {
        int sum = 0;
        for (String currentCard : cards) {
            int power = 0;
            switch (currentCard.charAt(0)) {
                case '1':
                    power = 10;
                    break;
                case '2':
                    power = 2;
                    break;
                case '3':
                    power = 3;
                    break;
                case '4':
                    power = 4;
                    break;
                case '5':
                    power = 5;
                    break;
                case '6':
                    power = 6;
                    break;
                case '7':
                    power = 7;
                    break;
                case '8':
                    power = 8;
                    break;
                case '9':
                    power = 9;
                    break;
                case 'J':
                    power = 11;
                    break;
                case 'Q':
                    power = 12;
                    break;
                case 'K':
                    power = 13;
                    break;
                case 'A':
                    power = 14;
                    break;
            }
            switch (currentCard.charAt(currentCard.length() - 1)) {
                case 'S':
                    sum += power * 4;
                    break;
                case 'H':
                    sum += power * 3;
                    break;
                case 'D':
                    sum += power * 2;
                    break;
                case 'C':
                    sum += power;
                    break;
            }
        }
        return sum;
    }
}
