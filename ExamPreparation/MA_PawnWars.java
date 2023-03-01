package ExamPreparation;

import java.util.Scanner;

public class MA_PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wRank = -1, wCol = -1;
        int bRank = -1, bCol = -1;

        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] == 'w') {
                    wRank = i;
                    wCol = j;
                }
                if (matrix[i][j] == 'b') {
                    bRank = i;
                    bCol = j;
                }
            }
        }
        boolean isHit = false;
        while (wRank > 0 && bRank < 7 && !isHit) {
            if (whitePawHitBlack(wRank, wCol, bRank, bCol)) {
                System.out.printf("Game over! White capture on %c%d.%n", getColumnSymbol(bCol), 8 - bRank);
                isHit = true;
            }
            wRank--;
            if (blackPawHitWhite(bRank, bCol, wRank, wCol)) {
                System.out.printf("Game over! Black capture on %c%d.%n", getColumnSymbol(wCol), 8 - wRank);
                isHit = true;
            }
            bRank++;
        }
        if (!isHit) {
            System.out.println(wRank == 0
                    ? "Game over! White pawn is promoted to a queen at " + getColumnSymbol(wCol) + "8."
                    : "Game over! Black pawn is promoted to a queen at " + getColumnSymbol(bCol) + "1."
            );
        }

    }

    private static char getColumnSymbol(int col) {
        return (char) (97 + col);
    }

    private static boolean blackPawHitWhite(int bRank, int bCol, int wRank, int wCol) {
        return bRank + 1 == wRank && (bCol + 1 == wCol || bCol - 1 == wCol);
    }

    private static boolean whitePawHitBlack(int wRank, int wCol, int bRank, int bCol) {
        return wRank - 1 == bRank && (wCol + 1 == bCol || wCol - 1 == bCol);
    }
}
