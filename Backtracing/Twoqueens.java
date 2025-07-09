public class Twoqueens {
    public static void nQueens(char board[][], int row) {
        // Base Case
        if (row == board.length) {
            printboard(board);
            return;
        }

        // Coloum loop

        for (int j = 0; j < board.length; j++) {
            board[row][j] = 'Q';

            // recursion
            nQueens(board, row + 1);

            // Backtracing

            board[row][j] = 'X';

        }

    }

    public static void printboard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  "); // First time logical error is occured due to println
            }
            System.out.println();

        }
        System.out.println();

    }

    public static void main(String[] args) {
        int n = 2;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';

            }
        }
        nQueens(board, 0);
    }

}
