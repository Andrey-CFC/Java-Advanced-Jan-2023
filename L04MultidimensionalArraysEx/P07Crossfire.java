package L04MultidimensionalArraysEx;

import java.util.*;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        int counter = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = counter + c;
            }
            counter += cols;
        }

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] measurments = command.split("\\s+");
            int row = Integer.parseInt(measurments[0]);
            int col = Integer.parseInt(measurments[1]);
            int radius = Integer.parseInt(measurments[2]);

            for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
                if (isInMatrix(currentRow, col, matrix)) {
                    matrix[currentRow][col] = -1;
                }
            }
            for (int currentColumn = col - radius; currentColumn <= col + radius; currentColumn++) {
                if (isInMatrix(row, currentColumn, matrix)) {
                    matrix[row][currentColumn] = -1;
                }
            }
            matrix = getMatrixAfterExplosion(matrix);
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInMatrix(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    private static int[][] getMatrixAfterExplosion(int[][] matrix) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        for (int r = 0; r < matrix.length; r++) {
            List<Integer> list = new ArrayList<>();
            int counter = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] != -1) {
                    list.add(matrix[r][c]);
                }
            }
            if (!list.isEmpty()) {
                map.put(r, list);
            }
        }
        matrix = new int[map.size()][];
        int startIndex = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            matrix[startIndex] = entry.getValue().stream().mapToInt(Integer::intValue).toArray();
            startIndex++;
        }
        return matrix;
    }
}
