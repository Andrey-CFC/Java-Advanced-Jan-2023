package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MA_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        char[][] matrix = new char[rows][columns];
        int xRow = -1, xCol = -1;
        int yRow = -1, yCol = -1;
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().replace(" ", "").toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'Y') {
                    yRow = i;
                    yCol = j;
                }
                if (matrix[i][j] == 'X') {
                    xRow = i;
                    xCol = j;
                }
            }
        }
        List<String> path = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    if (yRow > 0) {
                        char position = matrix[--yRow][yCol];
                        if (position == 'T') {
                            yRow++;
                        } else {
                            path.add(command);
                        }
                    }
                    break;
                case "down":
                    if (yRow < rows - 1) {
                        char position = matrix[++yRow][yCol];
                        if (position == 'T') {
                            yRow--;
                        } else {
                            path.add(command);
                        }
                    }
                    break;
                case "right":
                    if (yCol < columns - 1) {
                        char position = matrix[yRow][++yCol];
                        if (position == 'T') {
                            yCol--;
                        } else {
                            path.add(command);
                        }
                    }
                    break;
                case "left":
                    if (yCol > 0) {
                        char position = matrix[yRow][--yCol];
                        if (position == 'T') {
                            yCol++;
                        } else {
                            path.add(command);
                        }
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        if (yRow == xRow && yCol == xCol) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            String paths = String.join(", ",path);
            System.out.print(paths);
        } else {
            System.out.println("The map is fake!");
        }
    }
}
