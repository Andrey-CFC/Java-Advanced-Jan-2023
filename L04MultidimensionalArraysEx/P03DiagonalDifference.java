package L04MultidimensionalArraysEx;

import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] rowNums = scanner.nextLine().split("\\s+");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(rowNums[j]);
            }
        }
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        for (int i = 0; i < size; i++) {
            primaryDiagonal += matrix[i][i];
            secondaryDiagonal+= matrix[i][size-i-1];
        }
        System.out.println(Math.abs(primaryDiagonal-secondaryDiagonal));
    }
}
