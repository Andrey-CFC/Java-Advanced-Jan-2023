package L03MultidimensionalArrays;

import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] rowNums = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(rowNums[j]);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] matrixMax = new int[2][2];
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j+1]+matrix[i+1][j]+matrix[i+1][j+1];
                if (currentSum>maxSum){
                    maxSum = currentSum;
                    matrixMax[0][0] = matrix[i][j];
                    matrixMax[0][1] = matrix[i][j+1];
                    matrixMax[1][0] = matrix[i+1][j];
                    matrixMax[1][1] = matrix[i+1][j+1];
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrixMax[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
