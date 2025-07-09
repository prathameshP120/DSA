
//  1] Recursion + Memoization (Top-Down approach)

public class Fibonaci_series {

    // 1] Recursion + Memoization
    public static int solveUsingMemoisation(int n, int[] dp) {
        // Base case
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        // Step 3: Check if the answer already exists, then return the answer
        if (dp[n] != -1) {
            return dp[n];
        }

        // Recursive relation
        // Step 2: Store the answer in dp array
        dp[n] = solveUsingMemoisation(n - 1, dp) + solveUsingMemoisation(n - 2, dp);

        return dp[n];
    }

    public static int fib(int n) {
        // Step 1: Initialize dp array
        int dp[] = new int[n + 1];
        // Fill dp array with -1 (initial value indicating uncalculated)
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        // Calculate Fibonacci value using memoization
        return solveUsingMemoisation(n, dp);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fib(n));
    }
}

// 2] Tabulation Method (Bottom-UP Approach)

class Solution {
    public int solveUsingTabulation(int n) {
        // Step 1: Create dp array
        int[] dp = new int[n + 1];

        // Step 2: Analyze base cases and fill dp array
        dp[0] = 0;
        if (n == 0) {
            return 0;
        }
        dp[1] = 1;

        // Step 3: Fill the remaining dp array
        // Array size is n + 1
        // Index moves from 0 to n
        // Indices 0 and 1 are already filled
        // We need to fill indices from 2 to n
        for (int index = 2; index <= n; index++) {
            // Copy recursive logic
            // Replace recursive calls with dp array
            // Make sure dp array uses looping variable
            dp[index] = dp[index - 1] + dp[index - 2];
        }

        // Return the answer
        return dp[n];
    }

}
