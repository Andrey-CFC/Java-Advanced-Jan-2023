package L06SetsAndMapsAdvancedEx;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalElements = new TreeSet<>();
        while (--n >= 0) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            for (int i = 0; i < currentRow.length; i++) {
                if (!chemicalElements.contains(currentRow[i])) {
                    chemicalElements.add(currentRow[i]);
                }
            }
        }
        chemicalElements.forEach(element-> System.out.print(element+" "));
    }
}
