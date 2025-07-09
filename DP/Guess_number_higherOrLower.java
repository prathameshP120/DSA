import java.util.*;

public class Guess_number_higherOrLower {
    // public static int solveUsingRec(int start, int end) {
    // // base case
    // if (start >= end) {
    // // zero panlty
    // return 0;
    // }
    // int ans = Integer.MAX_VALUE;
    // for (int i = start; i <= end; i++) {
    // ans = Math.min(ans, i + Math.max(solveUsingRec(start, i - 1), solveUsingRec(i
    // + 1, end)));

    // }
    // return ans;

    // }
    public static int solveUsingRec(int start, int end) {
        // base case
        if (start >= end) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = i + Math.min(solveUsingRec(start, i - 1), solveUsingRec(i + 1, end));

        }
        return ans;
    }

    public static int solveUsingMem(int start, int end, int dp[][]) {
        if (start >= end) {
            // zero panlty
            return 0;
        }
        // if answer is already exist
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, i + Math.max(solveUsingMem(start, i - 1, dp), solveUsingMem(i + 1, end, dp)));

        }
        dp[start][end] = ans;

        return dp[start][end];

    }
    // In above tabulation , the start goes from 1 to n
    // And end goes from n to 1
    // Now in dp make reverse of that

    public static int solveUsingTabulation(int n) {
        int[][] dp = new int[n + 2][n + 1];

        for (int startIdx = n - 1; startIdx >= 1; startIdx--) {
            for (int endIdx = 1; endIdx <= n; endIdx++) {

                if (startIdx >= endIdx) {
                    // invalid range
                    continue;
                }

                int ans = Integer.MAX_VALUE;
                for (int i = startIdx; i <= endIdx; i++) {
                    ans = Math.min(ans, i + Math.max(dp[startIdx][i - 1], dp[i + 1][endIdx]));
                }
                dp[startIdx][endIdx] = ans;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int n = 10;
        int start = 0;
        int end = n;
        int dp[][] = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        // int ans = solveUsingRec(start, end);
        int ans = solveUsingMem(start, end, dp);
        System.out.println(ans);

    }
}