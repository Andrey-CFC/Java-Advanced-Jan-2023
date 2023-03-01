package ExamPreparation;

import java.util.Scanner;

public class MA_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int rows = -1;
        int columns = -1;
        char[][] matrix = new char[n][n];
        int snakeRow = -1, snakeCol = -1;
        int lairFirstRow = -1, lairFirstCol = -1;
        int lairSecondRow = -1, lairSecondCol = -1;
        for (int i = 1; i <= n; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j <= matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    snakeRow = i;
                    snakeCol = j;
                }
                if (matrix[i][j] == 'B') {
                    if (lairFirstRow == -1) {
                        lairFirstRow = i;
                        lairFirstCol = j;
                    } else {
                        lairSecondRow = i;
                        lairSecondCol = j;
                    }
                }
            }
        }
        int foodEaten = 0;
        while (foodEaten < 10) {
            String command = scanner.nextLine();
            markVisited(matrix, snakeRow, snakeCol);
            switch (command) {
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "up":
                    snakeRow--;
                    break;
            }
            if (snakeRow < 0 || snakeRow >= n || snakeCol < 0 || snakeCol >= n) {
                break;
            }
            if (matrix[snakeRow][snakeCol] == '*') {
                foodEaten++;
            }
            if (snakeRow == lairFirstRow && snakeCol == lairFirstCol) {
                markVisited(matrix, snakeRow, snakeCol);
                snakeRow = lairSecondRow;
                snakeCol = lairSecondCol;
            } else if (snakeRow == lairSecondRow && snakeCol == lairSecondCol) {
                markVisited(matrix, snakeRow, snakeCol);
                snakeRow = lairFirstRow;
                snakeCol = lairFirstCol;
            }
            matrix[snakeRow][snakeCol] = 'S';
        }
        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", foodEaten);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void markVisited(char[][] matrix, int row, int col) {
        matrix[row][col] = '.';
    }
}

