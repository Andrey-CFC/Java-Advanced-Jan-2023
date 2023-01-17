package L05SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> productsByStore = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);
            productsByStore.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> products = productsByStore.get(shop);
            products.put(product, price);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> entry : productsByStore.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (Map.Entry<String, Double> product : entry.getValue().entrySet()) {
               System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }
    }
}
