package L04MultidimensionalArraysEx;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char firstLetter = (char) (97 + i);
                char middleLetter = (char) (97 + i + j);
                matrix[i][j] = "" + firstLetter + middleLetter + firstLetter;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
