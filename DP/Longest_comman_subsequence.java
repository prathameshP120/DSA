import java.util.*;

public class Longest_comman_subsequence {

    public static int solveUsingRec(String str1, String str2, int i, int j) {
        // base case
        if (i < 0 || j < 0) {
            return 0;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + solveUsingRec(str1, str2, i - 1, j - 1);

        }
        return 0 + Math.max(solveUsingRec(str1, str2, i - 1, j), solveUsingRec(str1, str2, i, j - 1));

    }

    public static int solveUsingMem(String a, String b, int i, int j, int dp[][]) {
        // base case
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + solveUsingRec(a, b, i - 1, j - 1);

        }
        return dp[i][j] = Math.max(solveUsingRec(a, b, i - 1, j), solveUsingRec(a, b, i, j - 1));

    }

    public static int solveUsingTabulation(String a, String b) {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }
        // print the longest common subsequence
        printLCS(dp, a, b);
        return dp[n][m];
    }

    public static void printLCS(int dp[][], String a, String b) {
        // we start our search form the botttum-right corner of the dp array
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        int lenOfLCS = dp[dp.length - 1][dp[0].length - 1];
        Character ans[] = new Character[lenOfLCS];
        int index = lenOfLCS - 1;
        // up to top-left corner
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans[index] = a.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        for (char ch : ans) {
            System.out.println(ch);
        }
    }

    public static int solveUsingTabulationSO(String a, String b) {
        // Create two 1D arrays for current and next rows
        int[] curr = new int[a.length() + 1];
        int[] next = new int[a.length() + 1];

        // Loop through the string `b` from right to left
        for (int jIndex = b.length() - 1; jIndex >= 0; jIndex--) {
            // Loop through the string `a` from right to left
            for (int iIndex = a.length() - 1; iIndex >= 0; iIndex--) {
                int ans = 0;
                if (a.charAt(iIndex) == b.charAt(jIndex)) {
                    ans = 1 + next[iIndex + 1];
                } else {
                    ans = Math.max(next[iIndex], curr[iIndex + 1]);
                }
                curr[iIndex] = ans;
            }
            // Shift the current row to the next row for the next iteration
            next = curr.clone(); // Use `clone` to avoid reference issues
        }
        return next[0];
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abcd";
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        // int res = solveUsingRec(str1, str2, i, j);
        // System.out.println("lcs is :" + ans);

        // Using memoization
        // Initialize dp array with -1 (as this is memoization)
        int[][] dp = new int[str1.length()][str2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start the function with i = 0 and j = 0
        // int res = solveUsingMem(str1, str2, i, j, dp);

        int res = solveUsingTabulation(str1, str2);
        System.out.println(res);
        // using tabulationSpaceOptimization
        // int r = solveUsingTabulationSO(str1, str2);
        // System.out.println(r);

    }
}
