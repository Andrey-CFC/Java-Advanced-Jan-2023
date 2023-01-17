package L03MultidimensionalArrays;

import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][columns];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            String[] rowNums = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                sum += Integer.parseInt(rowNums[j]);
            }
        }
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}
