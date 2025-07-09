import java.util.*;

public class FirstProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matrix[][] = new int[3][3];

        int n = matrix.length;
        int m = matrix[0].length;

        // Taking the inpute from user

        System.out.println("Enter the element in an array ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();

            }
        }
        // For printing matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }

    }

}
