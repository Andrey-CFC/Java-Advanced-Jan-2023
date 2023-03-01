package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MA_RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();
        int km = 0;

        String[][] trace = new String[n][n];
        fillMatrix(trace, scanner);
        int currentRow = 0;
        int currentCol = 0;
        List<Integer> tunnelsCoordinates = new ArrayList<>();
        findTunnels(trace, tunnelsCoordinates);
        String direction = scanner.nextLine();
        while (!direction.equals("End")) {
            switch (direction) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }
            String currentPosition = trace[currentRow][currentCol];
            if (currentPosition.equals(".")) {
                km += 10;
            } else if (currentPosition.equals("T")) {
                    currentRow = tunnelsCoordinates.get(2);
                    currentCol = tunnelsCoordinates.get(3);
                    km += 30;
                    trace[tunnelsCoordinates.get(0)][tunnelsCoordinates.get(1)] = ".";
                    trace[tunnelsCoordinates.get(2)][tunnelsCoordinates.get(3)] = ".";
            } else if (currentPosition.equals("F")) {
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                km += 10;
                break;
            }

            direction = scanner.nextLine();
        }
        if (direction.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n",km);
        trace[currentRow][currentCol] = "C";
        for (int i = 0; i < trace.length; i++) {
            for (int j = 0; j < trace[0].length; j++) {
                System.out.print(trace[i][j]);
            }
            System.out.println();
        }
    }

    private static void findTunnels(String[][] trace, List<Integer> tunnelsCoordinates) {
        for (int row = 0; row < trace.length; row++) {
            for (int col = 0; col < trace.length; col++) {
                String currentElement = trace[row][col];
                if (currentElement.equals("T")) {
                    tunnelsCoordinates.add(row);
                    tunnelsCoordinates.add(col);
                }
            }
        }
    }
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
    }
}
