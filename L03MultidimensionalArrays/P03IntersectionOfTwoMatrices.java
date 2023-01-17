package L03MultidimensionalArrays;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        char[][] matrix1 = new char[rows][columns];
        char[][] matrix2 = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] rowChars1 = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix1[i][j] = rowChars1[j].charAt(0);
            }
        }
        for (int i = 0; i < rows; i++) {
            String[] rowChars2 = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix2[i][j] = rowChars2[j].charAt(0);
            }
        }
        char[][] matrixOutput = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    matrixOutput[i][j] = '*';
                } else {
                    matrixOutput[i][j] = matrix1[i][j];
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrixOutput[i][j]+" ");
            }
            System.out.println();
        }
    }
}
