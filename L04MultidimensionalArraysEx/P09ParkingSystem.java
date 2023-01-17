package L04MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean[][] isOccupied = new boolean[dimensions[0]][dimensions[1]];
        for (int i = 0; i < isOccupied.length; i++) {
            isOccupied[i][0] = true;
        }

        String input;
        while (!"stop".equals(input = scanner.nextLine())) {
            String[] measures = input.split("\\s+");
            int entryRow = Integer.parseInt(measures[0]);
            int desiredRow = Integer.parseInt(measures[1]);
            int desiredCol = Integer.parseInt(measures[2]);
            boolean hasFoundPlace = false;
            int distance = 1;
            distance += Math.abs(desiredRow - entryRow);

            if (!isOccupied[desiredRow][desiredCol]) {
                distance += desiredCol;
                isOccupied[desiredRow][desiredCol] = true;
                hasFoundPlace = true;
            } else {
                for (int i = 1; i < isOccupied[desiredRow].length && !hasFoundPlace; i++) {
                    if (desiredCol - i > 0 && !isOccupied[desiredRow][desiredCol - i]){
                        isOccupied[desiredRow][desiredCol - i] = true;
                        hasFoundPlace = true;
                        distance += desiredCol - i;
                    }

                    if (!hasFoundPlace && desiredCol + i < isOccupied[desiredRow].length
                            && !isOccupied[desiredRow][desiredCol + i]){
                        isOccupied[desiredRow][desiredCol + i] = true;
                        hasFoundPlace = true;
                        distance += i + desiredCol;
                    }
                }
            }
            if (hasFoundPlace){
                System.out.println(distance);
            } else {
                System.out.printf("Row %d full%n", desiredRow);
            }
        }
    }
}
