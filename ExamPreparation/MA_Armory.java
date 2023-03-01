package ExamPreparation;

import java.util.Scanner;

public class MA_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int officerRow = -1, officerCol = -1;
        int mirrorFirstRow = -1, mirrorFirstCol = -1;
        int mirrorSecondRow = -1, mirrorSecondCol = -1;
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'A') {
                    officerRow = i;
                    officerCol = j;
                }
                if (matrix[i][j] == 'M') {
                    if (mirrorFirstRow == -1) {
                        mirrorFirstRow = i;
                        mirrorFirstCol = j;
                    } else {
                        mirrorSecondRow = i;
                        mirrorSecondCol = j;
                    }
                }
            }
        }
        int swordsTotalValue = 0;
        while (swordsTotalValue < 65) {
            String command = scanner.nextLine();
            markVisited(matrix, officerRow, officerCol);
            switch (command) {
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "up":
                    officerRow--;
                    break;
            }
            if (officerRow < 0 || officerRow >= n || officerCol < 0 || officerCol >= n) {
                break;
            }
            if (Character.isDigit(matrix[officerRow][officerCol])) {
                Integer swordValue = (int) matrix[officerRow][officerCol] - 48;
                swordsTotalValue += swordValue;
            }
            if (officerRow == mirrorFirstRow && officerCol == mirrorFirstCol) {
                markVisited(matrix, officerRow, officerCol);
                officerRow = mirrorSecondRow;
                officerCol = mirrorSecondCol;
            } else if (officerRow == mirrorSecondRow && officerCol == mirrorSecondCol) {
                markVisited(matrix, officerRow, officerCol);
                officerRow = mirrorFirstRow;
                officerCol = mirrorFirstCol;
            }
            matrix[officerRow][officerCol] = 'A';
        }
        if (swordsTotalValue<65){
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n",swordsTotalValue);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void markVisited(char[][] matrix, int row, int col) {
        matrix[row][col] = '-';
    }
}
