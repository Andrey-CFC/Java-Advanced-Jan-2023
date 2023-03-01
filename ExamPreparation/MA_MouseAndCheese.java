package ExamPreparation;

import java.util.Scanner;

public class MA_MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] rowNums = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rowNums[j];
            }
        }
        int mouseRow = -1;
        int mouseColumn = -1;
        int cheese = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("M")) {
                    mouseRow = i;
                    mouseColumn = j;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            matrix[mouseRow][mouseColumn] = "-";

            switch (command) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseColumn--;
                    break;
                case "right":
                    mouseColumn++;
                    break;
            }
            if (!mouseIsInside(mouseRow, mouseColumn, n)) {
                System.out.println("Where is the mouse?");
                break;
            }
            String mouseCoordinates = matrix[mouseRow][mouseColumn];
            if (mouseCoordinates.equals("-")) {
                matrix[mouseRow][mouseColumn] = "M";
            } else if (mouseCoordinates.equals("c")) {
                cheese++;
                matrix[mouseRow][mouseColumn] = "M";
            } else if (mouseCoordinates.equals("B")) {
                matrix[mouseRow][mouseColumn] = "M";
                continue;
            }
            command = scanner.nextLine();
        }
        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        }
        printMatrix(matrix);
    }

    private static boolean mouseIsInside(int mouseRow, int mouseColumn, int n) {
        return mouseRow >= 0 && mouseRow < n && mouseColumn >= 0 && mouseColumn < n;
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
