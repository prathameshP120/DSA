public class PrintSprialMatrix {

    public static void PrintSpiral(int matrix[][]) {
        int SR = 0, SC = 0;
        int ER = matrix.length - 1, EC = matrix[0].length - 1;

        while (SR <= ER && SC <= EC) {
            // Top part
            for (int j = SC; j <= EC; j++) {
                System.out.print(matrix[SR][j] + " ");
            }
            // Right Part
            for (int j = SR + 1; j <= ER; j++) {

                System.out.print(matrix[j][EC] + " ");
            }
            // Bottom Part

            for (int j = EC - 1; j >= SC; j--) {

                System.out.print(matrix[ER][j] + " ");
            }

            for (int j = ER - 1; j >= SR; j--) {

                System.out.print(matrix[j][SC] + " ");
            }
            SR++;
            SC++;
            ER++;
            ER--;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 10, 11, 12, 13 }, { 14, 15, 16, 17 } };
        PrintSpiral(matrix);

    }
}

/*
 * 
 * class Solution {
 * public List<Integer> spiralOrder(int[][] matrix) {
 * List<Integer> result = new ArrayList<>();
 * if (matrix == null || matrix.length == 0) {
 * return result;
 * }
 * 
 * int SR = 0, SC = 0;
 * int ER = matrix.length - 1, EC = matrix[0].length - 1;
 * while (SR <= ER && SC <= EC) {
 * // Top part
 * for (int j = SC; j <= EC; j++) {
 * result.add(matrix[SR][j]);
 * }
 * // Right Part
 * for (int j = SR + 1; j <= ER; j++) {
 * result.add(matrix[j][EC]);
 * }
 * // Bottom Part
 * if (SR < ER) {
 * for (int j = EC - 1; j >= SC; j--) {
 * result.add(matrix[ER][j]);
 * }
 * }
 * // Left Part
 * if (SC < EC) {
 * for (int j = ER - 1; j > SR; j--) {
 * result.add(matrix[j][SC]);
 * }
 * }
 * SR++;
 * SC++;
 * ER--;
 * EC--;
 * }
 * return result;
 * }
 * }
 */