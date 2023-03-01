package ExamPreparation;

import java.util.Scanner;

public class MA_NavyBattle {
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
        int submarineRow = -1;
        int submarineColumn = -1;
        int health = 2;
        int cruisers = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("S")) {
                    submarineRow = i;
                    submarineColumn = j;
                }
            }
        }
        String command = scanner.nextLine();
        while (true) {

            matrix[submarineRow][submarineColumn] = "-";
            if (command.equals("up")) {
                submarineRow--;
            } else if (command.equals("down")) {
                submarineRow++;
            } else if (command.equals("left")) {
                submarineColumn--;
            } else if (command.equals("right")) {
                submarineColumn++;
            }
            String submarineCoordinates = matrix[submarineRow][submarineColumn];
            if (submarineCoordinates.equals("-")) {
                matrix[submarineRow][submarineColumn] = "S";
            } else if (submarineCoordinates.equals("*")) {
                health--;
                matrix[submarineRow][submarineColumn] = "S";
                if (health<0){
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",submarineRow,submarineColumn);
                break;
                }
            } else if(submarineCoordinates.equals("C")){
                cruisers++;
                matrix[submarineRow][submarineColumn] = "S";
                if (cruisers==3){
                    System.out.printf("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!%n");
                    break;
                }
            }
            command = scanner.nextLine();
        }
        printMatrix(matrix);
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
