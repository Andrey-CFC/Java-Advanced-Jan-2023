package L03MultidimensionalArrays;

import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            String[] rowNums = scanner.nextLine().split("\\s+");
            int[] currentRow = new int[rowNums.length];
            for (int j = 0; j < rowNums.length; j++) {
                currentRow[j] = Integer.parseInt(rowNums[j]);
            }
            matrix[i] = currentRow;
        }
        int wrongRow = scanner.nextInt();
        int wrongColumn = scanner.nextInt();
        int wrongNum = matrix[wrongRow][wrongColumn];
        int[][] newMatrix = new int[rows][matrix[0].length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == wrongNum) {
                    int currentSum = 0;
                    if (i >= 1) {
                        if (matrix[i - 1][j] != wrongNum) {
                            currentSum += matrix[i - 1][j];
                        }
                    }
                    if (i <= rows - 2) {
                        if (matrix[i + 1][j] != wrongNum) {
                            currentSum += matrix[i + 1][j];
                        }
                    }
                    if (j >= 1) {
                        if (matrix[i][j - 1] != wrongNum) {
                            currentSum += matrix[i][j - 1];
                        }
                    }
                    if (j <= matrix[0].length - 2) {
                        if (matrix[i][j + 1] != wrongNum) {
                            currentSum += matrix[i][j + 1];
                        }
                    }
                    newMatrix[i][j] = currentSum;
                } else {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
