package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SQ_EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] caffeineShots = scanner.nextLine().split(", ");
        Deque<Integer> caffeine = new ArrayDeque<>();
        for (String caffeineShot : caffeineShots) {
            caffeine.push(Integer.parseInt(caffeineShot));
        }
        String[] energyDrinksInput = scanner.nextLine().split(", ");
        Deque<Integer> energyDrinks = new ArrayDeque<>();
        for (String drink : energyDrinksInput) {
            energyDrinks.offer(Integer.parseInt(drink));
        }
        int stamatCaffeine = 0;
        int max = 300;
        while (!energyDrinks.isEmpty() && !caffeine.isEmpty()) {
            Integer caff = caffeine.pop();
            Integer energy = energyDrinks.poll();
            int potentialShot = caff * energy;
            if (stamatCaffeine + potentialShot <= max) {
                stamatCaffeine += potentialShot;
            } else {
                energyDrinks.offer(energy);
                stamatCaffeine -= 30;
                if (stamatCaffeine < 0) {
                    stamatCaffeine = 0;
                }
            }
        }
        if (!energyDrinks.isEmpty()) {
            String energy = energyDrinks.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Drinks left: %s%n", energy);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n",stamatCaffeine);
    }
}
