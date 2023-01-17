package L03MultidimensionalArrays;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chessboard = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String[] rowChars = scanner.nextLine().split("\\s+");
            for (int j = 0; j < 8; j++) {
                chessboard[i][j] = rowChars[j].charAt(0);
            }
        }
        int[] index = getIndexesByRow(chessboard);
        if (index[0] != -1) {
            System.out.printf("%d %d%n", index[0], index[1]);
        }
    }

    private static boolean searchInDiagonals(char[][] chessboard, int[] indexes) {
        int counter = 1;
        int row = indexes[0] + 1;
        int col = indexes[1] + 1;
        //down+right
        while (row < chessboard.length && col < chessboard[row].length) {
            if (chessboard[row][col] == 'q') {
                counter++;
            }
            row++;
            col++;
        }
        //down+left
        row = indexes[0] + 1;
        col = indexes[1] - 1;
        while (row < chessboard.length && col >= 0) {
            if (chessboard[row][col] == 'q') {
                counter++;
            }
            row++;
            col--;
        }
        row = indexes[0] - 1;
        col = indexes[1] - 1;
        //up+left
        while (row >= 0 && col >= 0) {
            if (chessboard[row][col] == 'q') {
                counter++;
            }
            row--;
            col--;
        }
        //up+right
        row = indexes[0] - 1;
        col = indexes[1] + 1;
        while (row >= 0 && col < chessboard[row].length) {
            if (chessboard[row][col] == 'q') {
                counter++;
            }
            row--;
            col++;
        }
        return (counter == 1);
    }

    private static boolean searchInColumn(char[][] chessboard, int[] indexes) {
        int row = 0;
        int col = indexes[1];
        int counter = 0;
        while (row < chessboard.length) {
            char currentChar = chessboard[row][col];
            if (currentChar == 'q') {
                counter++;
            }
            row++;
        }
        return (counter == 1);
    }

    private static int[] getIndexesByRow(char[][] chessboard) {
        int row = 0;
        int[] index = new int[2];
        while (row < chessboard.length) {
            int col = 0;
            int counter = 0;
            while (col < chessboard[row].length) {
                char currentChar = chessboard[row][col];
                if (currentChar == 'q') {
                    index[0] = row;
                    index[1] = col;
                    counter++;
                }
                col++;
            }
            if (counter == 1) {
                boolean isOneQueenInColumn = searchInColumn(chessboard, index);
                boolean isOneQueenInDiagonal = searchInDiagonals(chessboard, index);
                if (isOneQueenInColumn && isOneQueenInDiagonal) {
                    return index;
                }
            }
            row++;
        }
        index[0] = -1;
        index[1] = -1;
        return index;
    }
}
