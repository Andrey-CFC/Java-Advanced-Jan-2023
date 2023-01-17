package L04MultidimensionalArraysEx;

import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] rowNums = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(rowNums[j]);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] matrixMax = new int[3][3];
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < columns - 2; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    matrixMax[0][0] = matrix[i][j];
                    matrixMax[0][1] = matrix[i][j + 1];
                    matrixMax[0][2] = matrix[i][j + 2];
                    matrixMax[1][0] = matrix[i + 1][j];
                    matrixMax[1][1] = matrix[i + 1][j + 1];
                    matrixMax[1][2] = matrix[i + 1][j + 2];
                    matrixMax[2][0] = matrix[i + 2][j];
                    matrixMax[2][1] = matrix[i + 2][j + 1];
                    matrixMax[2][2] = matrix[i + 2][j + 2];
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrixMax[i][j] + " ");
            }
            System.out.println();
        }
    }
}
