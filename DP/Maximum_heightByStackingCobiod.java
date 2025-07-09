//This question is completely based on LIS

import java.util.ArrayList;
import java.util.Arrays;

public class Maximum_heightByStackingCobiod {

    public static boolean check(int curr[], int prev[]) {
        return curr[0] >= prev[0] && curr[1] >= prev[1] && curr[2] >= prev[2];
    }

    public static int max_heightByStackingCubiod(int cuboids[][]) {
        // firt sort each envolop in ascending order
        for (int cuboid[] : cuboids) {
            Arrays.sort(cuboid);

        }
        for (int i = 0; i < cuboids.length; i++) {
            for (int j = 0; j < cuboids[0].length; j++) {
                System.out.print(cuboids[i][j] + " ");
            }
            System.out.println();
        }

        // sort the cuboid on the basis of first index value of each envolop and arrange
        // them in ascending order

        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });

        System.out.println();

        for (int i = 0; i < cuboids.length; i++) {
            for (int j = 0; j < cuboids[0].length; j++) {
                System.out.print(cuboids[i][j] + " ");
            }
            System.out.println();
        }

        int n = cuboids.length;

        int dp[][] = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || check(cuboids[curr], cuboids[prev])) {
                    int heightToAdd = cuboids[curr][2];
                    include = heightToAdd + dp[curr + 1][curr + 1];
                }
                int exclude = 0 + dp[curr + 1][prev + 1];
                dp[curr][prev + 1] = Math.max(include, exclude);
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {
        int cuboids[][] = { { 50, 45, 20 }, { 95, 37, 53 }, { 45, 23, 12 } };
        int ans = max_heightByStackingCubiod(cuboids);
        System.out.println(ans);
    }

}
