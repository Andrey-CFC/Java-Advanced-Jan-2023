package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class SQ_01 {
    private static final int PATCH = 30;
    private static final int BANDAGE = 40;
    private static final int MEDKIT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] textilesInput = scanner.nextLine().split("\\s+");
        Deque<Integer> textiles = new ArrayDeque<>();
        for (String textile : textilesInput) {
            textiles.offer(Integer.parseInt(textile));
        }
        String[] medicamentsInput = scanner.nextLine().split("\\s+");
        Deque<Integer> medicaments = new ArrayDeque<>();
        for (String medicament : medicamentsInput) {
            medicaments.push(Integer.parseInt(medicament));
        }
        Map<String, Integer> medicamentsKit = new TreeMap<>(Map.of("Patch", 0, "Bandage", 0, "MedKit", 0));
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.poll();
            int medicament = medicaments.pop();
            int healingItem = textile + medicament;
            if (healingItem == PATCH) {
                medicamentsKit.put("Patch", medicamentsKit.get("Patch") + 1);
            } else if (healingItem == BANDAGE) {
                medicamentsKit.put("Bandage", medicamentsKit.get("Bandage") + 1);
            } else if (healingItem == MEDKIT) {
                medicamentsKit.put("MedKit", medicamentsKit.get("MedKit") + 1);
            } else if (healingItem > MEDKIT) {
                medicamentsKit.put("MedKit", medicamentsKit.get("MedKit") + 1);
                medicaments.push(medicaments.pop() + healingItem - MEDKIT);
            } else {
                medicaments.push(medicament + 10);
            }
        }
        if (!medicaments.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (!textiles.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles and medicaments are both empty.");
        }
        medicamentsKit.entrySet().stream().filter(entry -> entry.getValue() != 0).sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue())).forEach((entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue())));
        if (!medicaments.isEmpty()) {
            String medicamentsOutput = medicaments.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Medicaments left: %s%n",medicamentsOutput);
        }
        if (!textiles.isEmpty()) {
            String textilesOutput = textiles.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Textiles left: %s%n", textilesOutput);
        }
    }
}
