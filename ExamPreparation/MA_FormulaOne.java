package ExamPreparation;

import java.util.Scanner;

public class MA_FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] rowNums = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rowNums[j];
            }
        }
        int playerRow = -1;
        int playerColumn = -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j].equals("P")) {
                    playerRow = i;
                    playerColumn = j;
                    break;
                }
            }
        }
        boolean hasWon = false;
        for (int i = 1; i <= commandsCount; i++) {
            String move = scanner.nextLine();
            int newRow = 0;
            int newCol = 0;
            switch (move) {
                case "up":
                    newRow = checkIfIsOutside(playerRow - 1, size);
                    newCol = checkIfIsOutside(playerColumn, size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIfIsOutside(playerRow - 2, size);
                        newCol = checkIfIsOutside(playerColumn, size);
                    }
                    break;
                case "down":
                    newRow = checkIfIsOutside(playerRow + 1, size);
                    newCol = checkIfIsOutside(playerColumn, size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIfIsOutside(playerRow + 2, size);
                        newCol = checkIfIsOutside(playerColumn, size);
                    }
                    break;
                case "left":
                    newRow = checkIfIsOutside(playerRow, size);
                    newCol = checkIfIsOutside(playerColumn - 1, size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIfIsOutside(playerRow, size);
                        newCol = checkIfIsOutside(playerColumn - 2, size);
                    }
                    break;
                case "right":
                    newRow = checkIfIsOutside(playerRow, size);
                    newCol = checkIfIsOutside(playerColumn + 1, size);
                    if (matrix[newRow][newCol].equals("B")) {
                        newRow = checkIfIsOutside(playerRow, size);
                        newCol = checkIfIsOutside(playerColumn + 2, size);
                    }
                    break;
            }
            if (matrix[newRow][newCol].equals("T")) {
                newRow = playerRow;
                newCol = playerColumn;
            } else {
                if (matrix[newRow][newCol].equals("F")) {
                    hasWon = true;
                }
                matrix[playerRow][playerColumn] = ".";
                matrix[newRow][newCol] = "P";
                playerRow = newRow;
                playerColumn = newCol;
            }
        }
        if (hasWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static int checkIfIsOutside(int value, int size) {
        if (value < 0) {
            value = size - 1;
        } else if (value >= size) {
            value = 0;
        }
        return value;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
