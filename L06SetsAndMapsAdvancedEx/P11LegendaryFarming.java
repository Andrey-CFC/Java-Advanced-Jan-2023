package L06SetsAndMapsAdvancedEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        Map<String, Integer> quantityOfMaterials = new TreeMap<>();
        Map<String, Integer> quantityOfJunks = new TreeMap<>();
        quantityOfMaterials.put("shards", 250);
        quantityOfMaterials.put("fragments", 250);
        quantityOfMaterials.put("motes", 250);
        boolean isCollected = false;

        while (!isCollected) {
            String[] inputArr = input.split("\\s+");
            for (int i = 0; i < inputArr.length; i += 2) {
                String currentMaterial = inputArr[i + 1];
                int currentQuantity = Integer.parseInt(inputArr[i]);

                if (!quantityOfMaterials.containsKey(currentMaterial)) {
                    quantityOfJunks.putIfAbsent(currentMaterial, 0);
                    quantityOfJunks.put(currentMaterial, quantityOfJunks.get(currentMaterial) + currentQuantity);
                } else {
                    int updatedQuantity = quantityOfMaterials.get(currentMaterial) - currentQuantity;
                    if (updatedQuantity <= 0) {
                        System.out.println(getLegendaryItem(currentMaterial) + " obtained!");
                        updatedQuantity = 250 + updatedQuantity;
                        quantityOfMaterials.put(currentMaterial, updatedQuantity);
                        isCollected = true;
                        break;
                    } else {
                        quantityOfMaterials.put(currentMaterial, updatedQuantity);
                    }
                }
            }
                if (!isCollected) {
                    input = scanner.nextLine().toLowerCase();
                }
            }

            quantityOfMaterials.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), 250 - e.getValue()));

            for (Map.Entry<String, Integer> junk : quantityOfJunks.entrySet()) {
                System.out.printf("%s: %d%n", junk.getKey(), junk.getValue());
            }
        }

    private static String getLegendaryItem(String material) {
        if (material.equals("shards")) {
            return "Shadowmourne";
        } else if (material.equals("fragments")) {
            return "Valanyr";
        } else {
            return "Dragonwrath";
        }
    }
}

