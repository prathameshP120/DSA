public class Linear_search {
    public static boolean search(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("Key is found at cell" + "(" + i + "," + j + ")");
                    return true;
                }

            }
        }
        System.out.println("key is not found ");
        return false;

    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 3, 4, 5 },
                { 7, 8, 5, 4 },
                { 56, 98, 06, 23 }
        };

        int key = 06;
        search(matrix, key);
    }

}
