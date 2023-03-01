package ExamPreparation;

import java.util.Scanner;

public class MA_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        char[][] matrix = new char[rows][columns];
        int myRow = -1, myCol = -1;
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().replace(" ", "").toCharArray();
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 'B') {
                    myRow = i;
                    myCol = j;
                }
            }
        }
        int moves = 0;
        int touches = 0;
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {

            switch (command) {
                case "left":
                    if (isInMatrix(myRow, myCol - 1, matrix) && matrix[myRow][myCol - 1] != 'O') {
                        markVisited(matrix, myRow, myCol);
                        moves++;
                        if (matrix[myRow][myCol - 1] == 'P') {
                            touches++;
                        }
                        myCol--;
                    }
                    break;
                case "right":
                    if (isInMatrix(myRow, myCol + 1, matrix) && matrix[myRow][myCol + 1] != 'O') {
                        markVisited(matrix, myRow, myCol);
                        moves++;
                        if (matrix[myRow][myCol + 1] == 'P') {
                            touches++;
                        }
                        myCol++;
                    }
                    break;
                case "down":
                    if (isInMatrix(myRow + 1, myCol, matrix) && matrix[myRow + 1][myCol] != 'O') {
                        markVisited(matrix, myRow, myCol);
                        moves++;
                        if (matrix[myRow + 1][myCol] == 'P') {
                            touches++;
                        }
                        myRow++;
                    }
                    break;
                case "up":
                    if (isInMatrix(myRow - 1, myCol, matrix) && matrix[myRow - 1][myCol] != 'O') {
                        markVisited(matrix, myRow, myCol);
                        moves++;
                        if (matrix[myRow - 1][myCol] == 'P') {
                            touches++;
                        }
                        myRow--;
                    }
                    break;
            }
            matrix[myRow][myCol] = 'B';
            if (touches >= 3) {
                break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d%n", touches, moves);
    }

    private static boolean isInMatrix(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void markVisited(char[][] matrix, int row, int col) {
        matrix[row][col] = '.';
    }

}
