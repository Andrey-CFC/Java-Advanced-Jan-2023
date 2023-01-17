package L04MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < rows; row++) {
            String[] data = scanner.nextLine().split("");
            for (int col = 0; col < cols; col++) {
                if (data[col].equals("P")) {
                    playerRow = row;
                    playerCol = col;
                    matrix[row][col] = data[col];
                } else {
                    matrix[row][col] = data[col];
                }
            }
        }
        String[] commands = scanner.nextLine().split("");
        boolean isDead = false;
        boolean hasWon = false;

        for (int i = 0; i < commands.length; i++) {
            String direction = commands[i];
            if (direction.equals("U")) {
                if (playerRow - 1 < 0) {
                    hasWon = true;
                    matrix[playerRow][playerCol] = ".";
                } else {
                    if (matrix[playerRow - 1][playerCol].equals(".")) {
                        matrix[playerRow - 1][playerCol] = "P";
                        matrix[playerRow][playerCol] = ".";
                        playerRow--;
                    } else {
                        isDead = true;
                        matrix[playerRow][playerCol] = ".";
                        playerRow--;
                    }
                }
            } else if (direction.equals("D")) {
                if (playerRow + 1 == rows) {
                    hasWon = true;
                    matrix[playerRow][playerCol] = ".";
                } else {
                    if (matrix[playerRow + 1][playerCol].equals(".")) {
                        matrix[playerRow + 1][playerCol] = "P";
                        matrix[playerRow][playerCol] = ".";
                        playerRow++;
                    } else {
                        isDead = true;
                        matrix[playerRow][playerCol] = ".";
                        playerRow++;
                    }
                }
            } else if (direction.equals("L")) {
                if (playerCol - 1 < 0) {
                    hasWon = true;
                    matrix[playerRow][playerCol] = ".";
                } else {
                    if (matrix[playerRow][playerCol - 1].equals(".")) {
                        matrix[playerRow][playerCol - 1] = "P";
                        matrix[playerRow][playerCol] = ".";
                        playerCol--;
                    } else {
                        isDead = true;
                        matrix[playerRow][playerCol] = ".";
                        playerCol--;
                    }
                }
            } else if (direction.equals("R")) {
                if (playerCol + 1 == cols) {
                    hasWon = true;
                    matrix[playerRow][playerCol] = ".";
                } else {
                    if (matrix[playerRow][playerCol + 1].equals(".")) {
                        matrix[playerRow][playerCol + 1] = "P";
                        matrix[playerRow][playerCol] = ".";
                        playerCol++;
                    } else {
                        isDead = true;
                        matrix[playerRow][playerCol] = ".";
                        playerCol++;
                    }
                }
            }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if(matrix[row][col].equals("B")){
                        //Up
                        if(row-1 >= 0){
                            if (matrix[row-1][col].equals("P")){
                                isDead = true;
                                matrix[row-1][col] = "Bnew";
                            } else if (matrix[row-1][col].equals(".")){
                                matrix[row-1][col] = "Bnew";
                            }
                        }
                        //Down
                        if (row+1 < matrix.length){
                            if(matrix[row+1][col].equals("P")){
                                isDead = true;
                                matrix[row+1][col] = "Bnew";
                            } else if (matrix[row+1][col].equals(".")){
                                matrix[row+1][col] = "Bnew";
                            }
                        }
                        //Left
                        if (col -1 >= 0){
                            if (matrix[row][col-1].equals("P")){
                                isDead = true;
                                matrix[row][col-1] = "Bnew";
                            } else if (matrix[row][col-1].equals(".")) {
                                matrix[row][col-1] = "Bnew";
                            }
                        }
                        //Right
                        if (col +1 < matrix[row].length){
                            if(matrix[row][col+1].equals("P")){
                                isDead = true;
                                matrix[row][col+1] = "Bnew";
                            } else if (matrix[row][col+1].equals(".")) {
                                matrix[row][col+1] = "Bnew";
                            }
                        }
                    }
                }
            }
            matrix = growTheBunnies(matrix);
            if(isDead){
                printMatrix(matrix);
                System.out.printf("dead: %d %d", playerRow, playerCol);
                break;
            } else if (hasWon){
                printMatrix(matrix);
                System.out.printf("won: %d %d",playerRow,playerCol);
                break;
            }
        }
    }

    private static String[][] growTheBunnies(String[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c].equals("Bnew")){
                    matrix[r][c] = "B";
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
