package L03MultidimensionalArrays;

import java.util.Scanner;

public class P02PositionsOf {
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
        int number = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == number) {
                    System.out.println(i+" "+j);
                    isFound = true;
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }
}
