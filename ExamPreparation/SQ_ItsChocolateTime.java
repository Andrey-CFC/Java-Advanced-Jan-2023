package ExamPreparation;

import java.util.*;

public class SQ_ItsChocolateTime {
    private static final double MILK_CHOCOLATE = 30.0;
    private static final double DARK_CHOCOLATE = 50.0;
    private static final double BAKING_CHOCOLATE = 100.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] milkInput = scanner.nextLine().split("\\s+");
        Deque<Double> milkShots = new ArrayDeque<>();
        for (String milkShot : milkInput) {
            milkShots.offer(Double.parseDouble(milkShot));
        }
        String[] cacaoInput = scanner.nextLine().split("\\s+");
        Deque<Double> cacaoParts = new ArrayDeque<>();
        for (String cacaoPart : cacaoInput) {
            cacaoParts.push(Double.parseDouble(cacaoPart));
        }
        Map<String, Integer> chocolates = new TreeMap<>(Map.of("Milk Chocolate", 0, "Dark Chocolate", 0, "Baking Chocolate", 0));
        while (!milkShots.isEmpty() && !cacaoParts.isEmpty()) {
            double milk = milkShots.poll();
            double cacao = cacaoParts.pop();
            double cacaoPercentage = 100 * cacao / (milk + cacao);
            if (cacaoPercentage == MILK_CHOCOLATE) {
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
            } else if (cacaoPercentage == DARK_CHOCOLATE) {
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
            } else if (cacaoPercentage == BAKING_CHOCOLATE) {
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
            } else {
                milkShots.offer(milk + 10);
            }
        }
        if (chocolatesCollected(chocolates)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolates.entrySet().stream().filter(entry -> entry.getValue() != 0).sorted(Map.Entry.comparingByKey()).forEach((entry -> System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue())));

    }

    private static boolean chocolatesCollected(Map<String, Integer> chocolates) {
        boolean milkChocolate = chocolates.get("Milk Chocolate") >= 1;
        boolean darkChocolate = chocolates.get("Dark Chocolate") >= 1;
        boolean bakingChocolate = chocolates.get("Baking Chocolate") >= 1;
        return milkChocolate && darkChocolate && bakingChocolate;
    }
}
