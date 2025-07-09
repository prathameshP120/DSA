public class Staircase_Search {
    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("key is found at " + row + "," + col);
                return true;
            } else if (matrix[row][col] > key) {
                col--;
            } else {
                row--;
            }
        }
        System.out.println(" Key is not found ");
        return false;

    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        staircaseSearch(matrix, 32);
    }

}
