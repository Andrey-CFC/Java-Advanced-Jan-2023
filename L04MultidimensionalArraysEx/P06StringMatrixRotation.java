package L04MultidimensionalArraysEx;

import java.util.*;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int rotation = Integer.parseInt(command.split("[()]")[1]);
        rotation %= 360;
        String currentRow = scanner.nextLine();
        LinkedHashMap<Integer, String> rowsMap = new LinkedHashMap<>();
        int rows = 0;
        while (!currentRow.equals("END")) {
            rows++;
            rowsMap.put(rows, currentRow);
            currentRow = scanner.nextLine();
        }
        int maxLength = 0;
        for (String word : rowsMap.values()) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        switch (rotation) {
            case 0:
                char[][] matrix0 = new char[rows][maxLength];
                for (int i = 0; i < rows; i++) {
                    String currentWord = rowsMap.get(i + 1);
                    for (int j = 0; j < maxLength; j++) {
                        if (currentWord.length() > j) {
                            matrix0[i][j] = currentWord.charAt(j);
                        } else {
                            matrix0[i][j] = ' ';
                        }
                        System.out.print(matrix0[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                char[][] matrix90 = new char[maxLength][rows];
                for (int i = 0; i < rows; i++) {
                    String currentWord = rowsMap.get(rows-i);
                    for (int j = 0; j < maxLength; j++) {
                        if (currentWord.length() > j) {
                            matrix90[j][i] = currentWord.charAt(j);
                        } else {
                            matrix90[j][i] = ' ';
                        }
                    }
                }
                for (int i = 0; i < matrix90.length; i++) {
                    for (int j = 0; j < matrix90[0].length; j++) {
                        System.out.print(matrix90[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                char[][] matrix180 = new char[rows][maxLength];
                for (int i = rows - 1; i >= 0; i--) {
                    String currentWord = rowsMap.get(i + 1);
                    for (int j = maxLength - 1; j >= 0; j--) {
                        if (currentWord.length() > j) {
                            matrix180[i][j] = currentWord.charAt(j);
                        } else {
                            matrix180[i][j] = ' ';
                        }
                        System.out.print(matrix180[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                char[][] matrix270 = new char[maxLength][rows];
                for (int i = rows-1; i >= 0; i--) {
                    String currentWord = rowsMap.get(i+1);
                    for (int j = maxLength-1; j >= 0 ; j--) {
                        if (currentWord.length() > maxLength-1-j) {
                            matrix270[j][i] = currentWord.charAt(maxLength-1-j);
                        } else {
                            matrix270[j][i] = ' ';
                        }
                    }
                }
                for (int i = 0; i < matrix270.length; i++) {
                    for (int j = 0; j < matrix270[0].length; j++) {
                        System.out.print(matrix270[i][j]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
