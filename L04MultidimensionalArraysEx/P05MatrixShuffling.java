package L04MultidimensionalArraysEx;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] rowNums = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rowNums[j];
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (command.split("\\s+").length == 5) {
                String swapElement = "";
                String commandName = command.split("\\s+")[0];
                int row1 = Integer.parseInt(command.split("\\s+")[1]);
                int col1 = Integer.parseInt(command.split("\\s+")[2]);
                int row2 = Integer.parseInt(command.split("\\s+")[3]);
                int col2 = Integer.parseInt(command.split("\\s+")[4]);

                if (commandName.equals("swap") && row1 >= 0 && col1 >= 0 && row2 >= 0 && col2 >= 0 && row1 < rows && col1 < columns && row2 < rows && col2 < columns) {
                    swapElement = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = swapElement;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }
}
