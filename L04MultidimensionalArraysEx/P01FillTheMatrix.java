package L04MultidimensionalArraysEx;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        String pattern = input[1];
        int size = Integer.parseInt(input[0]);
        int[][] matrix = new int[size][size];
        switch (pattern) {
            case "A":
                matrix = getPatternAMatrix(size);
                break;
            case "B":
                matrix = getPatternBMatrix(size);
                break;
            default:
                break;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] getPatternBMatrix(int size) {
        int rows = size;
        int columns = size;
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j % 2 == 0) {
                    matrix[i][j] = j * size + i + 1;
                } else {
                    matrix[i][j] = j * size - i + size;
                }
            }
        }
        return matrix;
    }

    private static int[][] getPatternAMatrix(int size) {
        int rows = size;
        int columns = size;
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = j * size + i + 1;
            }
        }
        return matrix;
    }
}
