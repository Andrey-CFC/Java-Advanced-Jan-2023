package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MA_StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] moves = scanner.nextLine().split(",");
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] rowNums = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rowNums[j];
            }
        }
        int stolenMoney = 0;
        int thiefRow = -1;
        int thiefColumn = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("D")) {
                    thiefRow = i;
                    thiefColumn = j;
                    break;
                }
            }
        }
        for (String move : moves) {
            switch (move) {
                case "left":
                    if (thiefColumn - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[thiefRow][thiefColumn] = "+";
                        thiefColumn--;
                    }
                    break;
                case "right":
                    if (thiefColumn + 1 >= n) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[thiefRow][thiefColumn] = "+";
                        thiefColumn++;
                    }
                    break;
                case "up":
                    if (thiefRow - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[thiefRow][thiefColumn] = "+";
                        thiefRow--;
                    }
                    break;
                case "down":
                    if (thiefRow + 1 >= n) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[thiefRow][thiefColumn] = "+";
                        thiefRow++;
                    }
                    break;
            }
            String thiefCoordinates = matrix[thiefRow][thiefColumn];
            if (thiefCoordinates.equals("$")) {
                System.out.printf("You successfully stole %d$.%n", thiefRow * thiefColumn);
                stolenMoney += thiefRow * thiefColumn;
                matrix[thiefRow][thiefColumn] = "D";
            } else if (thiefCoordinates.equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                matrix[thiefRow][thiefColumn] = "#";
                printMatrix(matrix);
                return;
            } else if (thiefCoordinates.equals("+")) {
                matrix[thiefRow][thiefColumn] = "D";
            }
        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",stolenMoney);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
