package L03MultidimensionalArrays;

import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] rowNums = scanner.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(rowNums[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) {
                    System.out.print(matrix[i][j]+" ");
                }
            }
        }
        System.out.println();
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i+j==n-1) {
                    System.out.print(matrix[i][j]+" ");
                }
            }
        }
        System.out.println();
    }
}
