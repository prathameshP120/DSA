package partitionDp;

import java.util.Arrays;

public class MCM {
    public static int recursion(int arr[], int i, int j) {
        if (i == j) {
            return 0;
        }
        int mini = Integer.MAX_VALUE;
        // Try all possible partition
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + recursion(arr, i, k) + recursion(arr, k + 1, j);
            mini = Math.min(mini, steps);
        }
        return mini;
    }

    public static int memoization(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        // Try all possible partition
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + memoization(arr, i, k, dp) + memoization(arr, k + 1, j, dp);
            mini = Math.min(mini, steps);
        }
        return dp[i][j] = mini;
    }

    public static int tabulation(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 1; i >= 1; i--) {
            // j=>0->n-1 But i is always left of j
            for (int j = i + 1; j < n; j++) {
                int mini = Integer.MAX_VALUE;
                // Try all possible partition
                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String args[]) {

        int arr[] = { 10, 20, 30, 40, 50 };
        int n = arr.length;
        // int ans = recursion(arr, 1, n - 1);
        int dp[][] = new int[n][n];
        for (int r[] : dp) {
            Arrays.fill(r, -1);
        }
        // int ans = memoization(arr, 1, arr.length - 1, dp);
        int ans = tabulation(arr);
        System.out.println(ans);
    }
}
// PS C:\Users\patil\OneDrive\Desktop\DSA-ALL\DP> javac partitionDp/MCM.java
// PS C:\Users\patil\OneDrive\Desktop\DSA-ALL\DP> java partitionDp.MCM