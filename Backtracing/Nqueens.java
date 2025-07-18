import java.util.*;

public class Nqueens {

    public static boolean isSafe(char board[][], int row, int col) {

        // Vertical UP
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonally left Up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonally Right UP

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) { //

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

    public static void nQueens(char board[][], int row) {
        // Base Case
        if (row == board.length) {
            printboard(board);
            return;
        }

        // Coloum loop

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                // recursion
                nQueens(board, row + 1);
                // Backtracing
                board[row][j] = 'X';
            }
        }
    }

    public static void printboard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  "); // First time logical error is occured

            }
            System.out.println();

        }
        System.out.println();

    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';

            }
        }
        nQueens(board, 0);

    }
}
