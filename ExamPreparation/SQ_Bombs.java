package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class SQ_Bombs {
    private static final int DATURA_BOMB = 40;
    private static final int CHERRY_BOMB = 60;
    private static final int SMOKE_DECOY_BOMB = 120;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bombEffects = scanner.nextLine().split(", ");
        Deque<Integer> effects = new ArrayDeque<>();
        for (String effect : bombEffects) {
            effects.offer(Integer.parseInt(effect));
        }
        String[] bombCasings = scanner.nextLine().split(", ");
        Deque<Integer> casings = new ArrayDeque<>();
        for (String casing : bombCasings) {
            casings.push(Integer.parseInt(casing));
        }
        Map<String, Integer> bombPouch = new TreeMap<>(Map.of("Datura Bombs", 0, "Cherry Bombs", 0, "Smoke Decoy Bombs", 0));

        while (!bombPouchFilled(bombPouch) && !effects.isEmpty() && !casings.isEmpty()) {
            Integer effect = effects.peek();
            Integer casing = casings.pop();
            int potentialBomb = effect + casing;
            switch (potentialBomb) {
                case DATURA_BOMB:
                    bombPouch.put("Datura Bombs", bombPouch.get("Datura Bombs") + 1);
                    effects.poll();
                    break;
                case CHERRY_BOMB:
                    bombPouch.put("Cherry Bombs", bombPouch.get("Cherry Bombs") + 1);
                    effects.poll();
                    break;
                case SMOKE_DECOY_BOMB:
                    bombPouch.put("Smoke Decoy Bombs", bombPouch.get("Smoke Decoy Bombs") + 1);
                    effects.poll();
                    break;
                default:
                    casings.push(casing - 5);
                    break;
            }
        }
        if (bombPouchFilled(bombPouch)){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        if (effects.isEmpty()){
            System.out.println("empty");
        } else {
            String bombEffect = effects.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(bombEffect);
        }
        System.out.print("Bomb Casings: ");
        if (casings.isEmpty()){
            System.out.println("empty");
        } else {
            String bombCasing = casings.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(bombCasing);
        }
        bombPouch.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((entry-> System.out.printf("%s: %d%n",entry.getKey(),entry.getValue())));
    }

    private static boolean bombPouchFilled(Map<String, Integer> bombPouch) {
        boolean daturaBombsFilled = bombPouch.get("Datura Bombs") >= 3;
        boolean cherryBombsFilled = bombPouch.get("Cherry Bombs") >= 3;
        boolean smokeBombsFilled = bombPouch.get("Smoke Decoy Bombs") >= 3;
        return daturaBombsFilled && cherryBombsFilled && smokeBombsFilled;
    }
}