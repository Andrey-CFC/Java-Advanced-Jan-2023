package L03MultidimensionalArrays;

import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows1 = Integer.parseInt(dimensions[0]);
        int columns1 = Integer.parseInt(dimensions[1]);
        int[][] table1 = new int[rows1][columns1];
        for (int i = 0; i < rows1; i++) {
            String[] rowNums1 = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns1; j++) {
                table1[i][j] = Integer.parseInt(rowNums1[j]);
            }
        }
        dimensions = scanner.nextLine().split("\\s+");
        int rows2 = Integer.parseInt(dimensions[0]);
        int columns2 = Integer.parseInt(dimensions[1]);
        if (rows1 != rows2 || columns1 != columns2) {
            System.out.println("not equal");
            return;
        } else {
            int[][] table2 = new int[rows2][columns2];
            for (int i = 0; i < rows2; i++) {
                String[] rowNums2 = scanner.nextLine().split("\\s+");
                for (int j = 0; j < columns2; j++) {
                    table2[i][j] = Integer.parseInt(rowNums2[j]);
                }
            }
            for (int i = 0; i < rows1; i++) {
                for (int j = 0; j < columns1; j++) {
                    if (table1[i][j] != table2[i][j]) {
                        System.out.println("not equal");
                        return;
                    }
                }
            }
            System.out.println("equal");
        }
    }
}
